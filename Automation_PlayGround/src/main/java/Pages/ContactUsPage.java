package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Objects;

public class ContactUsPage {
    public WebDriver driver;
    public ContactUsPage(WebDriver driver){
        this.driver=driver;
    }
    By titleForm= By.xpath("(//h2[@class=\"title text-center\"])[2]");
    By nameForm=By.name("name");
    By emailForm=By.name("email");
    By subjectForm=By.name("subject");
    By messageForm=By.id("message");
    By submitForm=By.name("submit");
    By successFullMessage=By.xpath("//div[@class=\"status alert alert-success\"]");
    By HomeFormButton=By.cssSelector("a.btn.btn-success");
    //************************Assertion*************************************************
    public ContactUsPage checkThatContactUsPageLoadSuccessFull(){
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("/contact_us"));
        Assert.assertEquals(driver.findElement(titleForm).getText(),"GET IN TOUCH");
        return this;
    }
    public ContactUsPage checkThatFormShouldBeSubmitSuccessFull(){
        Assert.assertEquals(driver.findElement(successFullMessage).getText(),"Success! Your details have been submitted successfully.");
        Assert.assertTrue(driver.findElement(HomeFormButton).isDisplayed());
        return this;

    }


    //************************Action*************************************************
    public ContactUsPage fillContactUsForm(String name,String email,String subject,String message){
        driver.findElement(nameForm).sendKeys(name);
        driver.findElement(emailForm).sendKeys(email);
        driver.findElement(subjectForm).sendKeys(subject);
        driver.findElement(messageForm).sendKeys(message);
        return this;
    }
    public ContactUsPage clickOnSubmitButton(){
        driver.findElement(submitForm).click();
        driver.switchTo().alert().accept();
        return this;
    }
    public HomePage clickOnHomeFormButton(){
        driver.findElement(HomeFormButton).click();
        return new HomePage(driver);
    }
}
