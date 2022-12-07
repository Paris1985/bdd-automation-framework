package qa.hsf.tool.core.test;

import qa.hsf.tool.core.steps.LoginSteps;

public class LoginTest extends BaseTest{
  /*  @Before
    public void init() {
        ManagedWebDriver managedWebDriver = new ManagedWebDriver("test", new JSONObject());
        RemoteCucumberTestRunner.setThreadLocalWebDriver(managedWebDriver);
    }*/

    //@Test
    public void shouldBeAbleToLogin() {
        //Given
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.setUp();
        loginSteps.iAmOnTheLoginPage();
        //When
        loginSteps.tryToLogin();
        //Then
        loginSteps.loginSuccessfully();
    }
}
