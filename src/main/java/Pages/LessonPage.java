package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LessonPage extends PageBase {

    @FindBy(id = "preview")
    WebElement previewButton;


    public void clickSheetPreviewButton() {
        waitUntilElementIsVisible(previewButton, 120);
        clickOnElement(previewButton);
    }
}
