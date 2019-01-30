package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.MainPage;
import pages.ResultPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class Test_Content {

    Properties prop = new Properties();
    @Before
    public void precondition() throws InterruptedException, IOException {
        FileInputStream fis = new FileInputStream("C:\\Auto_Tests_Projects\\Snyk\\src\\main\\resources\\data.properties");
        prop.load(fis);
        setUP();
        login();
        moove_to_resources();

    }

    @Test
    public void create_post_with_videoCat_test() throws InterruptedException {
        //long now= System.currentTimeMillis();
        int a = 0;
        while (a < 3){
            long now= System.currentTimeMillis();
            create_post_with_video_cat(now);
            a++;//если это не написать то цикл будет бесконечным
        }
    }

    @Test
    public void create_post_CheatSheet_test() throws InterruptedException {

        //long now= System.currentTimeMillis();
        int a=0;
        while (a < 3) {
            long now= System.currentTimeMillis();
            create_post_with_CheatSheet_cat(now);
            a++;
        }

    }
    @Test
    public void iframe_fill_text_test() throws InterruptedException {
        SelenideElement frame=$("#content_ifr"),
                        textArea=$("#tinymce");

        $(By.xpath("//*[@class='page-title-action'][text()='Add new resource']")).click();
        switchTo().frame(frame);
        textArea.sendKeys(prop.getProperty("TEXTDATA"));
        switchTo().defaultContent();
        $("#in-resource-cat-26").click();

         Thread. sleep(9999999);


    }

    private void create_post_with_CheatSheet_cat(long now) throws InterruptedException {
        $(By.xpath("//*[@class='page-title-action'][text()='Add new resource']")).click();
        $("#title").setValue("AutoPost"+now);
        $("#in-resource-cat-26").click();
        $(By.xpath("//*[@id='carbon-field-1']/following-sibling::span[text()='Select Image']")).click();
        $(By.xpath("//*[@data-id='5411']")).click();
        $(By.xpath("//*[@id='__wp-uploader-id-0']//button[text()='Select Image']")).click();
        Thread.sleep(1000);
        $(By.xpath("//*[@id='carbon-field-2']/following-sibling::span[text()='Select Image']")).click();
        $(By.xpath("//*[@id='__wp-uploader-id-5']//*[@data-id='5408']")).click();
        $(By.xpath("//*[@id='__wp-uploader-id-5']//button[text()='Select Image']")).click();
        $("#publish").click();
        Thread.sleep(1500);
    }

    private void create_post_with_video_cat(long now) throws InterruptedException {
        $(By.xpath("//*[@class='page-title-action'][text()='Add new resource']")).click();
        $("#title").setValue("AutoPost"+now);
        $("#in-resource-cat-27").click();
        $(By.xpath("//*[@id='carbon-field-1']/following-sibling::span[text()='Select Image']")).click();
        $(By.xpath("//*[@data-id='5411']")).click();
        $(By.xpath("//*[@id='__wp-uploader-id-0']//button[text()='Select Image']")).click();
        Thread.sleep(1500);
        $(By.xpath("//*[@id='carbon-field-2']/following-sibling::span[text()='Select Image']")).click();
        $(By.xpath("//*[@id='__wp-uploader-id-5']//*[@data-id='5408']")).click();
        $(By.xpath("//*[@id='__wp-uploader-id-5']//button[text()='Select Image']")).click();
        $("#publish").click();
        Thread.sleep(1500);
    }

    private void moove_to_resources() {
        $(By.xpath("//*[@id='menu-posts-resource']//*[@class='wp-menu-name'] [text()='Resources']")).click();
    }

    private void login() throws InterruptedException {
        SelenideElement login=$("#wp-submit");
        Thread.sleep(1500);
        $("#user_login").setValue("admin");
        $("#user_pass").sendKeys("5500");
        Thread.sleep(1500);
        login.click();
    }

    private void setUP() {
        System.setProperty("selenide.browser", "chrome");

        clearBrowserCache();
        Configuration.timeout = 15000;
        open("http://snyk:Cfqn_Snyk@snyk.jaguar-team.com/admin");
    }
}
