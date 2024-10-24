package Pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Objects;

public class RegistrationSuccessfullPage {
    public WebDriver driver;
    private WebDriverWait wait;

    By RegistrationSuccessFullMessage=By.xpath("//h2[@data-qa=\"account-created\"]");
    By ContinueButton=By.xpath("//a[@data-qa=\"continue-button\"]");


    public  RegistrationSuccessfullPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }


    //---------------------------Assertions------------------------------------------/
    public RegistrationSuccessfullPage checkThatRegistrationSuccessFullMessageToBeDisplay(){
//        wait.until(ExpectedConditions.urlContains("/account_created"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(RegistrationSuccessFullMessage)));
       Assert.assertTrue((Objects.requireNonNull(driver.getCurrentUrl())).contains("account_created"));
        Assert.assertTrue(driver.findElement(RegistrationSuccessFullMessage).isDisplayed());
        Assert.assertEquals(driver.findElement(RegistrationSuccessFullMessage).getText(),"ACCOUNT CREATED!");
        return this;
        }

        //---------------------------Action------------------------------------------/
        public  HomePage clickOnContinueButton(){
            driver.findElement(ContinueButton).click();
            return new HomePage(driver);
        }


}
