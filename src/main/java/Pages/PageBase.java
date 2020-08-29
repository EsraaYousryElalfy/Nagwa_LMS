package Pages;

import browser.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageBase extends Driver {

    public PageBase() {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void submit(WebElement element) {
        element.submit();
    }

    public void sendKeysWithClear(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void presEnter() {
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    public List<String> getElementsText(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        elements.forEach(webElement -> texts.add(webElement.getText()));
        return texts;
    }

    public boolean isElementVisible(WebElement element) {
        return element.isDisplayed();
    }

    public void waitUntilElementIsVisible(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut /* seconds */);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
