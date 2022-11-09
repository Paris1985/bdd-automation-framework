package qa.hsf.tool.core.steps;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qa.hsf.tool.RemoteCucumberTestRunner;

public abstract class BaseSteps {
    protected WebDriver driver;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public BaseSteps() {
        driver = RemoteCucumberTestRunner.getManagedWebDriver().getWebDriverForPlatform();
    }
}
