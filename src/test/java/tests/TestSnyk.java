package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.ResultPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static pages.ResultPage.error404;
import static pages.ResultPage.testMyRepoBtn;

public class TestSnyk {

    MainPage mainPage;
    ResultPage resultPage;

    @Before
    public void setUp() {
        mainPage = new MainPage();
        resultPage = new ResultPage();

        System.setProperty("selenide.browser", "chrome");

        clearBrowserCache();
        Configuration.timeout = 15000;
        open("http://*******.jaguar-team.com/");
    }
    @Test
        public void GitLink() {
        mainPage.fillGitLinkField("https://github.com/select2/select2");
        mainPage.fillEmailField("test@etyhadar.com");
        mainPage.clickTestForFree();
        //mainPage.clickViewResults();
        switchTo().window("Vulnerability report for select2/select2 | Snyk");
        error404.shouldNot(exist);
        testMyRepoBtn.should(exist);
        }
    @Test
        public void npmLink(){

        mainPage.fillEmailField("test@etyhadar.com");
        mainPage.choseNPM_vcs();
        mainPage.fillNPMLinkField("selenidejs@0.2.1");
        mainPage.clickTestForFree();
//        mainPage.clickViewResults();
        switchTo().window("Vulnerability report for selenidejs@0.2.1 | Snyk");
        error404.shouldNot(exist);
        testMyRepoBtn.should(exist);
    }
    @After
    public void closeBrowser() {
        Selenide.close();
    }
}
