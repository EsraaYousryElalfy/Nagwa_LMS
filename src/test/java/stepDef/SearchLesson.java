package stepDef;

import Pages.HomePage;
import Pages.LessonPage;
import Pages.SearchResultPage;
import Pages.WorkSheetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SearchLesson {


    @Given("Open Home page")
    public void openHomePage() {
        HomePage homePage = new HomePage();
        homePage.goToHomePage();
    }

    @And("Choose {string} language")
    public void chooseLanguage(String language) {
        HomePage homePage = new HomePage();
        homePage.clickOnLanguage(language);
    }

    @And("search for {string} lesson")
    public void searchForLesson(String lesson) {
        HomePage homePage = new HomePage();
        homePage.searchForLesson(lesson);
    }

    @Then("all lessons in nagwa that match {string} name will appear")
    public void allLessonsInNagwaThatMatchNameWillAppear(String lesson) {
        SearchResultPage searchResult = new SearchResultPage();
        Assert.assertTrue(searchResult.getResults().stream().anyMatch(text->text.contains(lesson))
                || searchResult.getResultDescription().stream().anyMatch(text->text.contains(lesson)));
    }

    @When("click on lesson number {int}")
    public void clickOnLessonNumber(int number) {
        SearchResultPage searchResult = new SearchResultPage();
        searchResult.selectLesson(2);
    }

    @And("click on preview button")
    public void clickOnPreviewButton() {
        LessonPage lesson = new LessonPage();
        lesson.clickSheetPreviewButton();
    }

    @Then("Worksheet home page will open")
    public void worksheetHomePageWillOpen() {
        WorkSheetPage workSheet = new WorkSheetPage();
        Assert.assertTrue(workSheet.workSheetPageIsOpened());
    }

    @And("count number of questions is displayed")
    public void countNumberOfQuestionsIsDisplayed() {
        WorkSheetPage workSheet = new WorkSheetPage();
        Assert.assertTrue(workSheet.questionsCountIsDisplayed());
    }

    @And("print the questions cunts")
    public void printTheQuestionsCunts() {
        WorkSheetPage workSheet = new WorkSheetPage();
        System.out.println("The questions count in this worksheet is: " + workSheet.getQuestionsCunt());
    }
}
