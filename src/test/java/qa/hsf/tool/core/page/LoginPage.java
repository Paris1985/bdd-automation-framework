package qa.hsf.tool.core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement userNameBox;
    @FindBy(id = "password")
    private WebElement passwordBox;
    @FindBy(name = "login")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String user, String password) {
        writeText(userNameBox, user);
        writeText(passwordBox, password);
        click(loginBtn);
    }
}
