package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondApp {

        public static void main( String[] args )
        {

            WebDriver driver=new ChromeDriver();
//            driver.navigate().to("https://the-internet.herokuapp.com/login");
//            String url= driver.getCurrentUrl();
//            System.out.println("URL is:"+url);
//            System.out.println(driver.getTitle());
//            String header=driver.findElement(By.cssSelector("h4.subheader")).getText();
//            StringBuilder formattedHeader = new StringBuilder();
//
//            int maxLineLength = 30; // Set your desired maximum line length
//            for (int i = 0; i < header.length(); i += maxLineLength) {
//                formattedHeader.append(header, i, Math.min(i + maxLineLength, header.length()));
//                formattedHeader.append("\n");
//            }
//
//            System.out.println(formattedHeader.toString().trim());
//            System.out.println(header);
            driver.navigate().to("https://the-internet.herokuapp.com");
//            driver.findElement(By.linkText("Form Authentication")).click();
            driver.findElement(By.xpath("//a[@href=\"/login\"]")).click();
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.cssSelector("button.radius")).click();
            //driver.quit();

        }


}
