package qa.hsf.tool.core.test;



import org.junit.Test;
import qa.hsf.tool.core.steps.AlertSteps;

public class AlertStepsTest extends BaseTest{

   // @Test
    public void shouldBeAbleToOpenAlert() {
        AlertSteps alertSteps = new AlertSteps();
        alertSteps.before();
        alertSteps.openAlert();
    }
}
