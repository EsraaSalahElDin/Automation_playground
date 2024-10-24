package Tests;

import Pages.AccountSuccessFullDeletion;
import Pages.ContactUsPage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactUsTest {
    public WebDriver driver;
    HomePage homePage;
    ContactUsPage contactUsPage;

    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com");
    }
    @Test
    public void userCanContactUs(){
        new HomePage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessFull()
        .clickOnContactUsLink()
        .checkThatContactUsPageLoadSuccessFull()
        .fillContactUsForm("Esraa","Saranandah7&@gmail.com","hello","Message")
        .clickOnSubmitButton()
        .checkThatFormShouldBeSubmitSuccessFull()
        .clickOnHomeFormButton()
        .checkThatUserShouldBeNavigatedToHomePageSuccessFull();

    }
    @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        // driver.quit();
    }
}
