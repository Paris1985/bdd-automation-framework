package qa.hsf.tool.core.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.hsf.tool.core.page.HomePage;
import qa.hsf.tool.core.page.LoginPage;

public class LoginSteps extends BaseSteps{

    private HomePage homePage;
    private LoginPage loginPage;
    @Before
    public void setUp() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        homePage.goToHomePage()
                .goToLoginPage();
    }
    @When("I try to login with valid credentials")
    public void tryToLogin(){
        loginPage.login("qa", "qa@123");
    }

    @Then("I should be able to login successfully")
    public void loginSuccessfully() {
    }
    @After
    public void teardown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            logger.info("{} failed", scenario.getName());
        } else {
            logger.info("{} passed", scenario.getName());
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
