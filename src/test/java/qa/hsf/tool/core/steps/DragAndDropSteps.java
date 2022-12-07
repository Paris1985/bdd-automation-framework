package qa.hsf.tool.core.steps;


import io.cucumber.java.Before;
import qa.hsf.tool.core.page.DragAndDropPage;

public class DragAndDropSteps extends BaseSteps {

    private DragAndDropPage dragAndDropPage;

    @Before
    public void init() {
        dragAndDropPage = new DragAndDropPage(driver);
    }
    public void dragAndDrop() {
        dragAndDropPage.navigateToPage()
                .dragAndDrop();
    }
    public boolean isDragged() {
        return dragAndDropPage.isDragged();
    }

}
