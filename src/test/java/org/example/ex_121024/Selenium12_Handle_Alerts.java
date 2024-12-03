package org.example.ex_121024;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium12_Handle_Alerts {

    @Description("handle the alert popups")

    @Test
    public void areltpop(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //JS Alerts
       // WebElement dropdownElement = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
       //WebElement dropdownElement = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        // WebElement dropdownElement = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));

        //JS Confirm
        //WebElement dropdownElement1 = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));;

        //JS Prompt
        WebElement elementPrompt= driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        //dropdownElement.click();
        //dropdownElement1.click();
        elementPrompt.click();

        // Alerts
        //3 type- JS Alert, JS Contain, JSPrompt
        // Selenium can not handle native os pop-up alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

       Alert alert = driver.switchTo().alert();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       // System.out.println("Alert Text: " + alert.getText());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alert.sendKeys("Paliwal");
        alert.accept();
       //alert.dismiss();
        //Verify result text

        String result = driver.findElement(By.id("result")).getText();
       // Assert.assertEquals(result,"You entered: Paliwal");
        Assert.assertEquals(result,"You entered: PRAMOD");
        //driver.quit();
    }
}
