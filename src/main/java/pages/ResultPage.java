package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ResultPage {
    public static SelenideElement error404 = $(By.xpath("//*[text()='404: Page not found']")),
                                    testMyRepoBtn=$(By.xpath("//*[contains(text(),'Test my GitHub repositories')]"));
}
