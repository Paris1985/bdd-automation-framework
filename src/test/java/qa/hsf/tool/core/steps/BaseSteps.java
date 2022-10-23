package qa.hsf.tool.core.steps;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qa.hsf.tool.LocalCucumberTestRunner;
import qa.hsf.tool.RemoteCucumberTestRunner;
import qa.hsf.tool.core.driver.config.ManagedWebDriver;

public abstract class BaseSteps {
    protected WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    public BaseSteps() {
        ManagedWebDriver managedWebDriver = RemoteCucumberTestRunner.getManagedWebDriver();
        if(managedWebDriver == null){
            driver = LocalCucumberTestRunner.getWebDriver();
        }else {
            driver = RemoteCucumberTestRunner.getManagedWebDriver().getWebDriverForPlatform();
        }
    }
}
