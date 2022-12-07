package qa.hsf.tool.core.test;

import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilitiesUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteWebDriverTest {

    //@DataProvider(name = "remote", parallel = true)
    public Object[][] remoteTest() {
        String [][] data = {
                {"chrome" , "https://www.google.com/"},
                {"firefox" , "https://www.selenium.dev/"}
        };

        return data;
    }

   // @org.testng.annotations.Test(dataProvider = "remote")
    public void testRemoteWedDriver(String [] data) throws MalformedURLException, InterruptedException {


        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", data[0]);
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.100.95:4444/"), capabilities);
        driver.get(data[1]);
        Thread.sleep(2000);
        driver.quit();

    }

}
