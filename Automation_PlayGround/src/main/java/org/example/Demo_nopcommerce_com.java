package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Demo_nopcommerce_com {
    public static void main(String []arg){
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        try {
            // Create WebDriverWait with Duration
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate the checkbox
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));

            // Perform actions on the checkbox as needed
            checkbox.click();

            System.out.println("Checkbox checked.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }




    }
}
