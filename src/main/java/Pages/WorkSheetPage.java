package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WorkSheetPage extends PageBase {
    @FindBy(xpath = "//div[@class='worksheet-preview-page has-aside page']")
    WebElement workSheetPage;

    @FindBy(xpath = "//p[@class='inline-displayed']")
    List<WebElement> questionsCount;

    public boolean workSheetPageIsOpened() {
        waitUntilElementIsVisible(workSheetPage, 120);
        return isElementVisible(workSheetPage);
    }

    public boolean questionsCountIsDisplayed() {
        return isElementVisible(questionsCount.get(0));
    }

    public int getQuestionsCunt() {
        return questionsCount.size();
    }
}
