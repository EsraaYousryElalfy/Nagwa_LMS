package stepDef;

import browser.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public static void openBrowser() {
        Driver.openBrowser("Chrome");
    }

    @After
    public void closeBrowser() {
        Driver.CloseBrowser();
    }
}
