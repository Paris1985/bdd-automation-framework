package qa.hsf.tool.core.test;


import org.junit.Test;
import org.testng.Assert;
import qa.hsf.tool.core.steps.DragAndDropSteps;

public class DragAndDropTest extends BaseTest{

    @Test
    public void shouldBeAbleToDraAndDrop() {
        //Given
        DragAndDropSteps dragAndDropSteps = new DragAndDropSteps();
        dragAndDropSteps.init();
        //When
        dragAndDropSteps.dragAndDrop();
        //Then
        Assert.assertTrue(dragAndDropSteps.isDragged());
    }

}
