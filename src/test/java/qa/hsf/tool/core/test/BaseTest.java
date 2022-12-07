package qa.hsf.tool.core.test;

import org.json.simple.JSONObject;

import org.junit.After;
import org.junit.Before;
import qa.hsf.tool.CucumberTestRunner;
import qa.hsf.tool.core.driver.config.ManagedWebDriver;
import qa.hsf.tool.core.driver.config.WebDriverFactory;

public abstract class BaseTest {
    @Before
    public void init() {
        String testName = this.getClass().getName();
        ManagedWebDriver managedWebDriver = new ManagedWebDriver(testName, new JSONObject());
        CucumberTestRunner.setThreadLocalWebDriver(managedWebDriver);
    }
    @After
    public void tearDown() {
       // RemoteCucumberTestRunner.getWebDriver().quit();
    }
}
