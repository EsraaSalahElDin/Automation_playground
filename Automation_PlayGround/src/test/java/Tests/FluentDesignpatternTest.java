package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class FluentDesignpatternTest {
    Random random = new Random();int randomNumber = random.nextInt(10000);String uniqueEmail = "Saranandah" + randomNumber + "@gmail.com";
    WebDriver driver;
    WebDriverWait wait;//ExplicitlyWait
    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//implicitlyWait
    }
    @Test(priority=1)
    public void userCanRegisterSuccessfully(){

        new HomePage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessFull()
        .clickOnLogLink()
        .fillInSignUpName("EsraaSalahElDin")
        .fillInSignUpEmail(uniqueEmail)
        .clickOnSignUpButton()
        .checkLabelRegistrationShouldBeDisplay()
        .fillRegistrationPage()
        .clickOnButtonRegistration()
        .checkThatRegistrationSuccessFullMessageToBeDisplay();
        driver.manage().deleteAllCookies();
    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully",priority = 2)
    public void userCanLoginSuccessfully(){
        driver.navigate().to("https://automationexercise.com/login");
        new LoginNSignUpPage(driver).checkThatUserIsNavigatedToLoginNSignUpPage()
                .fillInLoginEmail(uniqueEmail)
                .fillInLoginPassword("Esraa123")
                .clickOnLoginButton()
                .checkThatLogOutLinkToBeDisplay();
    }
    @Test(dependsOnMethods = "userCanLoginSuccessfully",priority = 3)
    public void userCanLogOutSuccessfully(){
        new HomePage(driver).clickOnLogOutLink()
        .checkThatUserIsNavigatedToLoginNSignUpPage();
    }

    @Test(dependsOnMethods = "userCanLogOutSuccessfully",priority = 4)
    public void userCanDeleteAccount(){
        new LoginNSignUpPage(driver).checkThatUserIsNavigatedToLoginNSignUpPage()
        .fillInLoginEmail(uniqueEmail)
        .fillInLoginPassword("Esraa123")
        .clickOnLoginButton()
        .checkThatDeleteAccountLinkToBeDisplay()
        .clickOnDeleteAccountLink()
        .checkThatDeleteAccount()
        .clickOnContinueButton()
        .checkThatUserShouldBeNavigatedToHomePageSuccessFull()
        .checkThatLogInLinkToBeDisplay();
    }


    @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        // driver.quit();
    }
}
