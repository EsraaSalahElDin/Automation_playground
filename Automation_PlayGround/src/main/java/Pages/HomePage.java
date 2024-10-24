package Pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;
public class HomePage {
    public WebDriver driver;

    By loginLink=By.linkText("Signup / Login");
    By logOutLink=By.linkText("Logout");
    By deleteAccountLink=By.linkText("Delete Account");
    By  ContactUsLink=By.linkText("Contact us");



    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //---------------------------Assertions------------------------------------------/

    public HomePage checkThatLogOutLinkToBeDisplay() {
        Assert.assertTrue(driver.findElement(logOutLink).isDisplayed());
        return this;
    }
    public HomePage checkThatLogInLinkToBeDisplay() {
        Assert.assertTrue(driver.findElement(loginLink).isDisplayed());
        return this;
    }
    public HomePage checkThatDeleteAccountLinkToBeDisplay() {
        Assert.assertTrue(driver.findElement(deleteAccountLink).isDisplayed());
        return this;
    }
    public  HomePage checkThatUserShouldBeNavigatedToHomePageSuccessFull(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        return this;
    }


    //---------------------------Actions------------------------------------------/
    public  LoginNSignUpPage clickOnLogLink(){
        driver.findElement(loginLink).click();
        return new LoginNSignUpPage(driver);
    }
    public  LoginNSignUpPage clickOnLogOutLink(){
        driver.findElement(logOutLink).click();
        return new LoginNSignUpPage(driver);
    }
    public  AccountSuccessFullDeletion clickOnDeleteAccountLink(){
        driver.findElement(deleteAccountLink).click();
        return new AccountSuccessFullDeletion(driver);
    }
    public  ContactUsPage clickOnContactUsLink(){
        driver.findElement(ContactUsLink).click();
        return new ContactUsPage(driver);
    }

}
