package qa.hsf.tool.core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.hsf.tool.core.util.interactions.NavigationUtil;

public class AlertPage extends BasePage{

    @FindBy(id = "alertButton")
    private WebElement alertElement;

    public AlertPage(WebDriver driver) {
        super(driver);
        navigate("https://demoqa.com/alerts");
    }

    public String handleAlert() {
        waitElement(alertElement);
        click(alertElement);
        NavigationUtil util = new NavigationUtil();
        String alertText = util.alert();
        logger.info("Alert text {}", alertText);
        return alertText;
    }


}
