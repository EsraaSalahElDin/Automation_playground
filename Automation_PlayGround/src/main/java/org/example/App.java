package org.example;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.id("APjFqb")).sendKeys("selenium"+ Keys.ENTER);
        //driver.quit();

    }

}
