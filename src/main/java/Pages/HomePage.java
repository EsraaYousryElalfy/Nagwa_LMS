package Pages;

import browser.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    @FindBy(xpath = "//a[@href='/en/']")
    WebElement englishLanguage;

    @FindBy(xpath = "//a[@href='/fr/']")
    WebElement frenchLanguage;

    @FindBy(xpath = "//div[@class='search']/button")
    WebElement searchIcon;

    @FindBy(id = "txt_search_query")
    WebElement searchBar;

    @FindBy(id = "btn_global_search")
    WebElement submitSearch;

    public void goToHomePage() {
        driver.get("https://www.nagwa.com/");
    }

    public void clickOnLanguage(String language) {
        switch (language.toUpperCase()) {
            case "ENGLISH":
                clickOnElement(englishLanguage);
                break;
            case "French":
                clickOnElement(frenchLanguage);
                break;
        }
    }

    public void searchForLesson(String lesson) {
        waitUntilElementIsVisible(searchIcon, 120);
        clickOnElement(searchIcon);
        waitUntilElementIsVisible(searchBar, 120);
        sendKeysWithClear(searchBar, lesson);
        presEnter();
    }
}
