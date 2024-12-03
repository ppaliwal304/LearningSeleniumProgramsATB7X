package org.example.ex_121024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium07_Project1_Refinedcode {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--guest");
        chromeoptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeoptions);
    }
 @Description("Fill the form and registered in a account and verify ")
    @Test
    public void project1crudoperation(){
     driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/register");
        driver.findElement(By.id("input-firstname")).sendKeys("Pushpendra");
        driver.findElement(By.id("input-lastname")).sendKeys("Paliwal");
        //Unique mail every time by program
        String uniquemail = "ppaliwal"+System.currentTimeMillis()+"@yopmail.com";
        driver.findElement(By.name("email")).sendKeys(uniquemail);

        driver.findElement(By.name("telephone")).sendKeys("9140714494");
        driver.findElement(By.id("input-password")).sendKeys("Pass@123");
        driver.findElement(By.id("input-confirm")).sendKeys("Pass@123");
        driver.findElement(By.name("agree")).click();//click on checkbox
       //Click on continue button
        driver.findElement(By.className("btn-primary")).click();
     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));
       //Verify account created test
        WebElement verifytext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        Assert.assertTrue(verifytext.getText().contains("Your Account Has Been Created!"));
        driver.quit();
    }
}
