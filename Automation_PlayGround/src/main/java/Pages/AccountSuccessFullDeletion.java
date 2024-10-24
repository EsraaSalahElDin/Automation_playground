package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Objects;

public class AccountSuccessFullDeletion {
    public WebDriver driver;

    By labelDeleteAccount=By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By ContinueButton=By.xpath("//a[@data-qa=\"continue-button\"]");

    public  AccountSuccessFullDeletion(WebDriver driver){
        this.driver=driver;
    }


    //---------------------------Assertions------------------------------------------/


    public  AccountSuccessFullDeletion checkThatDeleteAccount(){
        Assert.assertTrue(driver.getCurrentUrl().contains("delete_account"));
        Assert.assertTrue(driver.findElement(labelDeleteAccount).isDisplayed());
        Assert.assertEquals(driver.findElement(labelDeleteAccount).getText(),"ACCOUNT DELETED!");
        return this;
    }
    //---------------------------Action------------------------------------------/


    public  HomePage clickOnContinueButton(){
        driver.findElement(ContinueButton).click();
        return new HomePage(driver);
    }

}
