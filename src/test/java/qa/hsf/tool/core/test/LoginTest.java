package qa.hsf.tool.core.test;

import org.junit.Test;
import qa.hsf.tool.core.steps.LoginSteps;

public class LoginTest {

    @Test
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
