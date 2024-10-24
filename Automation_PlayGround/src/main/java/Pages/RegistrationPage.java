package Pages;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Objects;

public class RegistrationPage {
    public WebDriver driver;
    private WebDriverWait wait;
    By LabelRegistrationPage=By.xpath("(//h2[@class=\"title text-center\"])[1]");

    By titleGenderIsMrs=By.id("id_gender2");
    By titleGenderIsMr=By.id("id_gender1");
    By passwordRegistration=By.id("password");
    By dayDDl=By.id("days");
    By monthDDl=By.id("months");
    By yearsDDl=By.id("years");
    By signUpFForOurNewsletterCheckBox=By.id("newsletter");
    By receiveSpecialOffersFromOurPartnersCheckBox=By.id("optin");
    By first_Name=By.id("first_name");
    By last_Name=By.id("last_name");
    By companyRegistration=By.id("company");
    By addressRegistration=By.id("address1");
    By countryDropdown=By.id("country");
    By stateRegistration=By.id("state");
    By cityRegistration=By.id("city");
    By zipcodeRegistration=By.id("zipcode");
    By mobile_numberRegistration=By.id("mobile_number");
    By buttonRegistration=By.cssSelector("button.btn.btn-default");

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }


    //---------------------------Assertion------------------------------------------/
     public RegistrationPage checkLabelRegistrationShouldBeDisplay(){
        Assert.assertEquals(driver.findElement(LabelRegistrationPage).getText(),"ENTER ACCOUNT INFORMATION");
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/signup");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
        return this;
     }

    //---------------------------Actions------------------------------------------/
    public  RegistrationPage fillRegistrationPage(){
        driver.findElement(titleGenderIsMrs).click();
        driver.findElement(titleGenderIsMr).click();
        driver.findElement(passwordRegistration).sendKeys("Esraa123");
        driver.findElement(dayDDl).click();
        Select select=new Select(driver.findElement(dayDDl));
        select.selectByIndex(5);
        select.selectByValue("1");
        driver.findElement(monthDDl).click();
        Select selectMonthsDDL=new Select(driver.findElement(monthDDl));
        selectMonthsDDL.selectByIndex(3);
        selectMonthsDDL.selectByValue("7");
        driver.findElement(yearsDDl).click();
        Select selectYearsDDL=new Select(driver.findElement(yearsDDl));
        selectYearsDDL.selectByIndex(0);
        selectYearsDDL.selectByValue("1987");
        driver.findElement(signUpFForOurNewsletterCheckBox).click();
        driver.findElement(receiveSpecialOffersFromOurPartnersCheckBox).click();
        driver.findElement(first_Name).sendKeys("Esraa");
        driver.findElement(last_Name).sendKeys("Metwally");
        driver.findElement(companyRegistration).sendKeys("AHBS");
        driver.findElement(addressRegistration).sendKeys("Alex");
        driver.findElement(countryDropdown).click();
        Select selectCountryDropdown=new Select(driver.findElement(countryDropdown));
        selectCountryDropdown.selectByIndex(5);
        driver.findElement(stateRegistration).sendKeys("state");
        driver.findElement(cityRegistration).sendKeys("city");
        driver.findElement(zipcodeRegistration).sendKeys("Zipcode");
        driver.findElement(mobile_numberRegistration).sendKeys("01004863067");
        return this;

    }
    public RegistrationSuccessfullPage clickOnButtonRegistration(){
        driver.findElement(buttonRegistration).click();
        return new RegistrationSuccessfullPage(driver);
    }
//    public void selectTitleGenderIsMrs(){
//        driver.findElement(titleGenderIsMrs).click();
//    }
//    public void selectTitleGenderIsMr(){
//        driver.findElement(titleGenderIsMr).click();
//    }
//    public void fillRegistrationPagePassword(String password){
//        driver.findElement(passwordRegistration).sendKeys(password);
//        driver.findElement(receiveSpecialOffersFromOurPartnersCheckBox).click();
//        driver.findElement(first_Name).sendKeys("Esraa");
//        driver.findElement(last_Name).sendKeys("Metwally");
//        driver.findElement(companyRegistration).sendKeys("AHBS");
//        driver.findElement(addressRegistration).sendKeys("Alex");
//        driver.findElement(countryDropdown).click();
//        Select selectCountryDropdown=new Select(driver.findElement(countryDropdown));
//        selectCountryDropdown.selectByIndex(5);
//        selectCountryDropdown.selectByValue("Singapore");
//
//    }
//    public void selectDayDDl(){
//        driver.findElement(dayDDl).click();
//        Select select=new Select(driver.findElement(dayDDl));
//        select.selectByIndex(5);
//        select.selectByValue("1");
//    }
//
//    public void selectMonthDDl(){
//        driver.findElement(monthDDl).click();
//        Select selectMonthsDDL=new Select(driver.findElement(monthDDl));
//        selectMonthsDDL.selectByIndex(3);
//        selectMonthsDDL.selectByValue("7");
//    }
//    public void selectYearDDl(){
//        driver.findElement(yearsDDl).click();
//        Select selectYearsDDL=new Select(driver.findElement(yearsDDl));
//        selectYearsDDL.selectByIndex(0);
//        selectYearsDDL.selectByValue("1987");
//    }
//    public void checkSignUpFForOurNewsletterCheckBox(){
//        driver.findElement(signUpFForOurNewsletterCheckBox).click();
//    }
//    public void checkReceiveSpecialOffersFromOurPartnersCheckBox(){
//        driver.findElement(receiveSpecialOffersFromOurPartnersCheckBox).click();
//    }
//    public void fillFirstName(String firstName){
//        driver.findElement(first_Name).sendKeys(firstName);
//    }
//    public void fillLastName(String lastName){
//        driver.findElement(last_Name).sendKeys(lastName);
//    }
//    public void fillCompanyRegistration(String company){
//        driver.findElement(companyRegistration).sendKeys(company);
//    }
//    public void fillAddressRegistration(String address){
//        driver.findElement(addressRegistration).sendKeys(address);
//    }
//    public void selectCountryDropdown(){
//        driver.findElement(countryDropdown).click();
//        Select selectCountryDropdown=new Select(driver.findElement(countryDropdown));
//        selectCountryDropdown.selectByIndex(5);
//        selectCountryDropdown.selectByValue("Singapore");
//    }
//
//
//    public void fillStateRegistration(String state){
//        driver.findElement(stateRegistration).sendKeys(state);
//    }
//    public void fillCityRegistration(String city){
//        driver.findElement(cityRegistration).sendKeys(city);
//    }
//    public void fillZipcodeRegistration(String Zipcode){
//        driver.findElement(zipcodeRegistration).sendKeys(Zipcode);
//    }
//    public void fillMobile_numberRegistration(String Mobile_number){
//        driver.findElement(mobile_numberRegistration).sendKeys(Mobile_number);
//    }




}

