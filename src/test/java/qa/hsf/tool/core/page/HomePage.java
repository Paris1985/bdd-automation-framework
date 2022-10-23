package qa.hsf.tool.core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    @FindBy(className = "noo-search")
    private WebElement searchLink;
    @FindBy(xpath = "//form/input[1]")
    private WebElement searchBox;
    @FindBy(className = "woocommerce-result-count")
    private WebElement resultCount;

    public HomePage(WebDriver webDriver) {
        super(webDriver);

    }

    public void search(String searchString) {
        waitElement(searchLink);
        click(searchLink);

        waitElement(searchBox);
        writeText(searchBox, searchString);
        submit(searchBox);
    }

    public String getResult() {
        waitElement(resultCount);
        return readText(resultCount);
    }

    public HomePage goToHomePage() {
        String appUrl = "https://shop.demoqa.com";
        this.driver.get(appUrl);
        this.driver.manage().window().maximize();
        return this;
    }
    public HomePage goToLoginPage() {
        this.driver.navigate().to("https://shop.demoqa.com/my-account/");
        return this;
    }
}
