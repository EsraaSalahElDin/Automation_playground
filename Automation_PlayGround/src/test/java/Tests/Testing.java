package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.Random;

public class Testing {

    LoginNSignUpPage loginNSignUpPage;
    RegistrationSuccessfullPage registrationSuccessfullPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    AccountSuccessFullDeletion accountSuccessFullDeletion;
    //ContactUsPage contactUsPage;
    Random random = new Random();
    int randomNumber = random.nextInt(10000);  // Generates a number between 0 and 9999
    String uniqueEmail = "Saranandah" + randomNumber + "@gmail.com";
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com");
    }
    @Test(priority=1)
    public void userCanRegisterSuccessfully(){
        loginNSignUpPage=new LoginNSignUpPage(driver);
        registrationSuccessfullPage =new RegistrationSuccessfullPage(driver);
        registrationPage=new RegistrationPage(driver);
        homePage=new HomePage(driver);
        accountSuccessFullDeletion=new AccountSuccessFullDeletion(driver);
        //contactUsPage=new ContactUsPage(driver);

        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessFull();
        homePage.clickOnLogLink();
        loginNSignUpPage.fillInSignUpName("EsraaSalahElDin");
        loginNSignUpPage.fillInSignUpEmail(uniqueEmail);
        loginNSignUpPage.clickOnSignUpButton();
        registrationPage.checkLabelRegistrationShouldBeDisplay();
        registrationPage.fillRegistrationPage();
//        registrationPage.selectTitleGenderIsMrs();
//        registrationPage.fillRegistrationPagePassword("Esraa123");
//        registrationPage.selectDayDDl();
//        registrationPage.selectMonthDDl();
//        registrationPage.selectYearDDl();
//        registrationPage.checkSignUpFForOurNewsletterCheckBox();
//        registrationPage.checkReceiveSpecialOffersFromOurPartnersCheckBox();
//        registrationPage.fillFirstName("Esraa");
//        registrationPage.fillLastName("Mitwally");
//        registrationPage.fillCompanyRegistration("AHBS");
//        registrationPage.fillAddressRegistration("Alex");
//        registrationPage.selectCountryDropdown();
//        registrationPage.fillStateRegistration("State");
//        registrationPage.fillCityRegistration("Alexandria");
//        registrationPage.fillZipcodeRegistration("12345");
//        registrationPage.fillMobile_numberRegistration("01004863067");
        registrationPage.clickOnButtonRegistration();
        registrationSuccessfullPage.checkThatRegistrationSuccessFullMessageToBeDisplay();
        driver.manage().deleteAllCookies();
    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully",priority = 2)
    public void userCanLoginSuccessfully(){
        driver.navigate().to("https://automationexercise.com/login");
        loginNSignUpPage.checkThatUserIsNavigatedToLoginNSignUpPage();
        loginNSignUpPage.fillInLoginEmail(uniqueEmail);
        loginNSignUpPage.fillInLoginPassword("Esraa123");
        loginNSignUpPage.clickOnLoginButton();
        homePage.checkThatLogOutLinkToBeDisplay();
    }
    @Test(dependsOnMethods = "userCanLoginSuccessfully",priority = 3)
    public void userCanLogOutSuccessfully(){
       homePage.clickOnLogOutLink();
       homePage.checkThatLogInLinkToBeDisplay();
       loginNSignUpPage.checkThatUserIsNavigatedToLoginNSignUpPage();
    }

    @Test(dependsOnMethods = "userCanLogOutSuccessfully",priority = 4)
    public void userCanDeleteAccount(){
        loginNSignUpPage.checkThatUserIsNavigatedToLoginNSignUpPage();
        loginNSignUpPage.fillInLoginEmail(uniqueEmail);
        loginNSignUpPage.fillInLoginPassword("Esraa123");
        loginNSignUpPage.clickOnLoginButton();
        homePage.checkThatDeleteAccountLinkToBeDisplay();
        homePage.clickOnDeleteAccountLink();
        accountSuccessFullDeletion.checkThatDeleteAccount();
        accountSuccessFullDeletion.clickOnContinueButton();
        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessFull();
        homePage.checkThatLogInLinkToBeDisplay();
    }
//    @Test(dependsOnMethods = "userCanDeleteAccount",priority = 5)
//    public void userCanContactUs(){
//        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessFull();
//        homePage.clickOnContactUsLink();
//        contactUsPage.checkThatContactUsPageLoadSuccessFull();
//        contactUsPage.fillContactUsForm("Esraa","Saranandah7&@gmail.com","hello","Message");
//        contactUsPage.clickOnSubmitButton();
//        contactUsPage.checkThatFormShouldBeSubmitSuccessFull();
//        contactUsPage.clickOnHomeFormButton();
//        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessFull();
//
//    }

    @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
       // driver.quit();
    }
}


