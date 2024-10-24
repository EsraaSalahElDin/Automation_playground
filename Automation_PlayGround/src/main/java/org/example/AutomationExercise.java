package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class AutomationExercise {
    public static void main(String []arg) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://automationexercise.com/login");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("Esraa1");
        // driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("Saranandah7@gmail.com1");
        Random random = new Random();
        int randomNumber = random.nextInt(10000);  // Generates a number between 0 and 9999

        // Create a unique email for every run
        String uniqueEmail = "Saranandah" + randomNumber + "@gmail.com";
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(uniqueEmail);
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("Esraa123");

        WebElement dayDDL=driver.findElement(By.id("days"));
        Select select=new Select(dayDDL);
        select.selectByIndex(5);
        select.selectByValue("1");

        WebElement monthsDDL=driver.findElement(By.id("months"));
        Select selectMonthsDDL=new Select(monthsDDL);
        selectMonthsDDL.selectByIndex(3);
        selectMonthsDDL.selectByValue("7");

        WebElement yearsDDL=driver.findElement(By.id("years"));
        Select selectYearsDDL=new Select(yearsDDL);
        selectYearsDDL.selectByIndex(0);
        selectYearsDDL.selectByValue("1987");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
        driver.findElement(By.id("first_name")).sendKeys("Esraa");
        driver.findElement(By.id("last_name")).sendKeys("SalahElDin");
        driver.findElement(By.id("company")).sendKeys("companySalahElDin");
        driver.findElement(By.id("address1")).sendKeys("address1companySalahElDin");
       // driver.findElement(By.xpath("//option[@value=\"Australia\"]")).click();
        //How select value of drop down list
        WebElement countryDropdown=driver.findElement(By.id("country"));
        Select selectCountryDropdown=new Select(countryDropdown);
        selectCountryDropdown.selectByIndex(5);
        selectCountryDropdown.selectByValue("Singapore");

        driver.findElement(By.id("state")).sendKeys("State");
        driver.findElement(By.id("city")).sendKeys("city");
        driver.findElement(By.id("zipcode")).sendKeys("zipcode");
        driver.findElement(By.id("mobile_number")).sendKeys("01004863067");
        driver.findElement(By.cssSelector("button.btn.btn-default")).click();

driver.quit();


    }
}
