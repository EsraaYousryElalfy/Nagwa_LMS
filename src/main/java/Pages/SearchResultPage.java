package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends PageBase {

    @FindBy(xpath = "//UL[@class='list']//a")
    List<WebElement> resultList;

    @FindBy(xpath = "//div[@class='right']/p")
    List<WebElement> resultDescription;


    public List<String> getResults() {
        waitUntilElementIsVisible(resultList.get(0), 120);
        return getElementsText(resultList);
    }

    public void selectLesson(int lesson) {
        clickOnElement(resultList.get(lesson - 1));
    }

    public List<String> getResultDescription() {
        return getElementsText(resultDescription);
    }

    public boolean isSearchResultsContainsLesson(String lesson) {
        return getResults().stream().anyMatch(text -> text.contains(lesson)) ||
                getResultDescription().stream().anyMatch(text -> text.contains(lesson));
    }
}
