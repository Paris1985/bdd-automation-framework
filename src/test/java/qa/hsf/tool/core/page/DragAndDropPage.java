package qa.hsf.tool.core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    @FindBy(id = "draggable")
    private WebElement draggableElement;
    @FindBy(id="droppable")
    private WebElement droppableElement;


    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage navigateToPage() {
        navigate("https://demoqa.com/droppable/");
        return this;
    }


    public void dragAndDrop(){
       dragAndDrop(draggableElement, droppableElement);
    }

    public boolean isDragged() {
        String textTo = droppableElement.getText();
        return textTo.equals("Dropped!");
    }
}
