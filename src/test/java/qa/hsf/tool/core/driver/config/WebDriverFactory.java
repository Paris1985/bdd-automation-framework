package qa.hsf.tool.core.driver.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qa.hsf.tool.core.util.Utility;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebDriverFactory {

    private static final String DEFAULT_LOCAL_BROWSER = "chrome";
    private static volatile WebDriverFactory instance;
    private final JSONObject testConfig = this.parseWebDriverConfig();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private List<String> supportedBrowsers = new ArrayList<>();

    private WebDriverFactory() {
    }

    public static WebDriverFactory getInstance() {
        if (instance == null) {
            synchronized (WebDriverFactory.class) {
                if (instance == null) {
                    instance = new WebDriverFactory();
                }
            }
        }
        return instance;
    }

    private JSONObject parseWebDriverConfig() {
        JSONParser parser = new JSONParser();
        String capabilitiesConfigFile = System.getProperty("caps", "src/test/resources/conf/parallel.conf.json");
        try {
            JSONObject testConfig = (JSONObject) parser.parse(new FileReader(capabilitiesConfigFile));
            return testConfig;
        } catch (IOException | ParseException var6) {
            throw new Error("Unable to parse capabilities file " + capabilitiesConfigFile, var6);
        }
    }

    public JSONObject getTestConfig() {
        return testConfig;
    }

    public List<JSONObject> getPlatforms() {
        Object environments1 = testConfig.get("environments");
        List<JSONObject> platforms = new ArrayList<>();

        if (environments1 instanceof JSONObject) {
            JSONObject singleConfig = Utility.getCombinedCapability((Map<String, String>) environments1, testConfig);
            platforms.add(singleConfig);
        } else if (environments1 instanceof JSONArray) {
            JSONArray environments = (JSONArray) environments1;
            for (Object obj : environments) {
                JSONObject singleConfig = Utility.getCombinedCapability((Map<String, String>) obj, testConfig);
                platforms.add(singleConfig);
            }
        }

        return platforms;
    }

    public WebDriver createWebDriverForPlatform(JSONObject platform, String testName) {
        try {

            String username = System.getenv("QA_USERNAME");
            if (username == null) {
                logger.info("username was not setup in environment");
                username = System.getProperty("user");
            }

            String accessKey = System.getenv("QA_ACCESS_KEY");
            if (accessKey == null) {
                logger.info("access key was not setup in environment");
                accessKey = System.getProperty("key");
            }

            String server = System.getenv("QA_SERVER");
            if (server == null) {
                logger.info("server was not setup in environment");
                server = System.getProperty("server");
            }

            MutableCapabilities caps = new MutableCapabilities(platform);
            caps.setCapability("name", "[" + platform.get("browserName") + "] " + testName);

            WebDriver webDriver = null;
            String runType = System.getProperty("run");
            logger.info("Run type is {}", runType);
            if(runType == null) {
                logger.info("Setting run type to null");
                runType = "local";
            }

            if(runType.equals("local")) {
                if (platform.isEmpty()) {
                    webDriver = createDefaultWebDriver();
                } else {
                    webDriver = WebDriverManager.getInstance((String) platform.get("browserName")).create();
                }
                return webDriver;
            } else if (server != null && accessKey != null && username != null) {

                StringBuilder urlBuilder = new StringBuilder();

                urlBuilder.append("https://")
                        .append(username)
                        .append(":")
                        .append(accessKey)
                        .append("@")
                        .append(server)
                        .append("/wd/hub");
                webDriver = new RemoteWebDriver(new URL(urlBuilder.toString()), caps);
            }else{
                logger.error("not supported configuration");
            }
            return webDriver;
        } catch (MalformedURLException var4) {
            throw new Error("Unable to create WebDriver", var4);
        } catch (WebDriverManagerException e) {
            logger.warn("Browser {} is not supported", platform.get("browserName"));
            logger.warn("Using default browser {}", DEFAULT_LOCAL_BROWSER);
            return createDefaultWebDriver();
        }
    }

    public WebDriver createDefaultWebDriver() {
        String browser = System.getProperty("browser");
        if (browser != null)
            verify(browser);
        else {
            logger.warn("Browser not provided, setting default browser to " + DEFAULT_LOCAL_BROWSER);
            browser = DEFAULT_LOCAL_BROWSER;
        }

        return WebDriverManager.getInstance(browser).create();
    }

    private void verify(String browser) {
        List<String> supportedBrowsers = List.of("edge", "chrome", "safari", "firefox", "ie");
        if (!supportedBrowsers.contains(browser)) {
            throw new InvalidArgumentException("The provided browser " + browser + " is not yet supported");
        }
    }

}
