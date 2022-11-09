package qa.hsf.tool;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.hsf.tool.core.driver.config.LazyInitWebDriverIterator;
import qa.hsf.tool.core.driver.config.ManagedWebDriver;

import java.util.Iterator;

@CucumberOptions(
        glue = "qa.hsf.tool.core.steps",
        plugin = {
                "pretty",
                "html:reports/tests/cucumber/html",
                "timeline:reports/tests/cucumber/timeline",
                "junit:reports/tests/cucumber/junit/cucumber.xml",
                "testng:reports/tests/cucumber/testng/cucumber.xml",
                "json:reports/tests/cucumber/json/cucumber.json"
        }
)
public class RemoteCucumberTestRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private TestNGCucumberRunner testNGCucumberRunner;
    private static final ThreadLocal<ManagedWebDriver> threadLocalWebDriver = new ThreadLocal<>();

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    public static WebDriver getWebDriver() {

        return WebDriverManager.getInstance("chrome").create();
    }

    private synchronized static void setThreadLocalWebDriver(ManagedWebDriver managedWebDriver) {
        threadLocalWebDriver.set(managedWebDriver);
    }

    public synchronized static ManagedWebDriver getManagedWebDriver() {
        return threadLocalWebDriver.get();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void feature(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper, ManagedWebDriver managedWebDriver) {

        managedWebDriver.setTestName(pickleWrapper.getPickle().getName());
        setThreadLocalWebDriver(managedWebDriver);
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider(name = "scenarios", parallel = true)
    public Iterator<Object[]> scenarios() {
        Object[][] scenarios = testNGCucumberRunner.provideScenarios();
        logger.info("scenarios {}", scenarios);
        return new LazyInitWebDriverIterator(scenarios);
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }

}
