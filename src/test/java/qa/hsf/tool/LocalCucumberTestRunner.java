package qa.hsf.tool;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

@CucumberOptions(
        features = "classpath:features",
        glue = "qa.hsf.tool.core.steps",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class LocalCucumberTestRunner extends AbstractTestNGCucumberTests {

    public static WebDriver getWebDriver() {

        return WebDriverManager.getInstance("chrome").create();
    }

}