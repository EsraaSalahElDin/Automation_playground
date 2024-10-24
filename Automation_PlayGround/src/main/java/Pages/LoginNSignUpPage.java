package Pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class LoginNSignUpPage {

    public WebDriver driver;

    //-----------------------------LogIn-------------------------------------------------/
    By loginEmail=By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPassword=By.name("password");
    By loginButton=By.xpath("//button[@data-qa=\"login-button\"]");

    //-----------------------------signUp-------------------------------------------------/
    //By signUpName=By.xpath("//input[@data-qa=\"signup-name\"]");
    By labelSignUp=By.xpath("(//h2)[3]");
    By signUpName=By.name("name");
    By signUpEmail=By.xpath("(//input[@name='email'])[2]");
    By signUpButton=By.xpath("//button[@data-qa=\"signup-button\"]");

    public  LoginNSignUpPage(WebDriver driver){
        this.driver=driver;

    }
//---------------------------Assertions------------------------------------------/
    public LoginNSignUpPage checkThatUserIsNavigatedToLoginNSignUpPage(){
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/login"));
        Assert.assertEquals(driver.findElement(labelSignUp).getText(),"New User Signup!");
        return this;
    }
//------------------------------------------------------------------------------/
//---------------------------Actions------------------------------------------/
//-----------------------------LogIn-------------------------------------------------/
    public LoginNSignUpPage fillInLoginEmail(String email){
        driver.findElement(loginEmail).sendKeys(email);
        return this;
    }
    public LoginNSignUpPage fillInLoginPassword(String password){
        driver.findElement(loginPassword).sendKeys(password);
        return this;
    }
    public HomePage clickOnLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

   //-----------------------------signUp-------------------------------------------------//
    public LoginNSignUpPage fillInSignUpName(String name){
        driver.findElement(signUpName).sendKeys(name);
        return this;
    }
    public LoginNSignUpPage fillInSignUpEmail(String email){
        driver.findElement(signUpEmail).sendKeys(email);
        return this;
    }
    public RegistrationPage clickOnSignUpButton(){
        driver.findElement(signUpButton).click();
        return new RegistrationPage(driver);
    }
//------------------------------------------------------------------------------/

}
