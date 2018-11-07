package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.impl.Html.text;

public  class MainPage {

    public static SelenideElement gitLinkField=$("#github_test_url-108914f2-a116-4813-9e8b-bf997db0d33c"),
                                    emailField=$("#email-108914f2-a116-4813-9e8b-bf997db0d33c"),
                                    testForFreeBtn=$(By.xpath("//*[@value='Test for free']")),
                                    viewResultsBtn=$(By.xpath("//*[text()='view results']")),
                                    droplistVCS=$("#select2-test_type-108914f2-a116-4813-9e8b-bf997db0d33c-container"),
                                    chooseNPM=$(By.xpath("//*[@class='select2-results__options']//*[text()='npm']")),
                                    npmLinkField=$("#npm_test_package-108914f2-a116-4813-9e8b-bf997db0d33c");
    public static void fillGitLinkField(String text) {
        gitLinkField.sendKeys(text);
    }

    public static void fillEmailField(String text) {
        emailField.sendKeys(text);
    }

    public static void clickTestForFree() {
        testForFreeBtn.click();
    }

    public void clickViewResults() {
        viewResultsBtn.should(Condition.enabled).click();
    }

    public void choseNPM_vcs() {
        //Selenide.executeJavaScript("arguments[0].scrollIntoView(true);",linkField);
        droplistVCS.click();
        chooseNPM.click();
    }

    public void fillNPMLinkField(String text) {
        npmLinkField.sendKeys(text);
    }
}
