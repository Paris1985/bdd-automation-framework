package qa.hsf.tool.core.util.interactions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.hsf.tool.CucumberTestRunner;

import java.time.Duration;

public class NavigationUtil {
    private WebDriverWait wait;
    private WebDriver driver;
    public NavigationUtil(){
        WebDriver driver = CucumberTestRunner.getManagedWebDriver().getWebDriverForPlatform();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public <T> String alert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text;
    }

}
