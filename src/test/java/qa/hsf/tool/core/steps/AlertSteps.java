package qa.hsf.tool.core.steps;

import io.cucumber.java.Before;
import qa.hsf.tool.core.page.AlertPage;

public class AlertSteps extends BaseSteps{
    private AlertPage alertPage;

    @Before
    public void before() {
        alertPage = new AlertPage(driver);
    }
    public void openAlert() {
        String alertText = alertPage.handleAlert();
    }

}
