package Tests;

import Pages.HomePage;
import Pages.LoginNSignUpPage;
import Pages.RegistrationPage;
import Pages.RegistrationSuccessfullPage;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.Objects;
import java.util.Random;

public class NewTest {
    LoginNSignUpPage loginNSignUpPage;
    RegistrationSuccessfullPage registrationSuccessfullPage;
    HomePage homePage;
    RegistrationPage registrationPage;
    Random random = new Random();
    int randomNumber = random.nextInt(10000);  // Generates a number between 0 and 9999
    String uniqueEmail = "Saranandah" + randomNumber + "@gmail.com";
    WebDriver driver;
    @BeforeClass
    public void setUp(){
//        ChromeOptions options=new ChromeOptions();Options to display as mobile mode /had smode /without display ui
//        driver=new ChromeDriver(options);
        driver=new ChromeDriver();
        driver.navigate().to("https://automationexercise.com/login");
        driver.manage().window().maximize();
    }

    // Create a unique email for every run

    @Test(priority=1)
    public void userCanRegisterSuccessfully(){
        loginNSignUpPage=new LoginNSignUpPage(driver);
        registrationSuccessfullPage =new RegistrationSuccessfullPage(driver);
        registrationPage=new RegistrationPage(driver);
        homePage=new HomePage(driver);
        loginNSignUpPage.fillInSignUpName("EsraaSalahElDin");
        loginNSignUpPage.fillInSignUpEmail(uniqueEmail);
        loginNSignUpPage.clickOnSignUpButton();
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

//        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("Esraa1");
//        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("Saranandah7@gmail.com1");
//        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(uniqueEmail);
//        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();

//        driver.findElement(By.id("id_gender2")).click();
//        driver.findElement(By.id("password")).sendKeys("Esraa123");

//        WebElement dayDDL=driver.findElement(By.id("days"));
//        Select select=new Select(dayDDL);
//        select.selectByIndex(5);
//        select.selectByValue("1");
//
//        WebElement monthsDDL=driver.findElement(By.id("months"));
//        Select selectMonthsDDL=new Select(monthsDDL);
//        selectMonthsDDL.selectByIndex(3);
//        selectMonthsDDL.selectByValue("7");
//
//        WebElement yearsDDL=driver.findElement(By.id("years"));
//        Select selectYearsDDL=new Select(yearsDDL);
//        selectYearsDDL.selectByIndex(0);
//        selectYearsDDL.selectByValue("1987");

//        driver.findElement(By.id("newsletter")).click();
//        driver.findElement(By.id("optin")).click();
//        driver.findElement(By.id("first_name")).sendKeys("Esraa");
//        driver.findElement(By.id("last_name")).sendKeys("SalahElDin");
//        driver.findElement(By.id("company")).sendKeys("companySalahElDin");
//        driver.findElement(By.id("address1")).sendKeys("address1companySalahElDin");
//        // driver.findElement(By.xpath("//option[@value=\"Australia\"]")).click();
//        //How select value of drop down list
//        WebElement countryDropdown=driver.findElement(By.id("country"));
//        Select selectCountryDropdown=new Select(countryDropdown);
//        selectCountryDropdown.selectByIndex(5);
//        selectCountryDropdown.selectByValue("Singapore");
//
//        driver.findElement(By.id("state")).sendKeys("State");
//        driver.findElement(By.id("city")).sendKeys("city");
//        driver.findElement(By.id("zipcode")).sendKeys("zipcode");
//        driver.findElement(By.id("mobile_number")).sendKeys("01004863067");
//        driver.findElement(By.cssSelector("button.btn.btn-default")).click();
//
////        WebElement successfullyCreated=driver.findElement(By.xpath("//h2[@data-qa=\"account-created\"]"));
////        Assert.assertTrue((Objects.requireNonNull(driver.getCurrentUrl())).contains("account_created"));
////        Assert.assertTrue(successfullyCreated.isDisplayed());
////        Assert.assertEquals(successfullyCreated.getText(),"ACCOUNT CREATED!");
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
//        driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys(uniqueEmail);
//        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("Esraa123");
//        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();

//        WebElement logOut= driver.findElement(By.linkText("Logout"));
//        Assert.assertTrue(logOut.isDisplayed());
    }
    @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
