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

public class Selenium08_Project2_Refinedcode {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--guest");
        chromeoptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeoptions);
    }
 @Description("Click on Start a free trial and after that signup ")
    @Test
    public void project2crudoperation(){
     driver.navigate().to("https://app.vwo.com/#/login");
     //driver.findElement(By.className("text-link")).click();// Type-1
        WebElement linkText = driver.findElement(By.linkText("Start a free trial"));//Type-2
        linkText.click();
        String uniquemail1 = "ppaliwal"+System.currentTimeMillis()+"@yopmail.com";
        driver.findElement(By.id("page-v1-step1-email")).sendKeys(uniquemail1);
        driver.findElement(By.name("gdpr_consent_checkbox")).click();
        driver.findElement(By.className("btn-modal-form-submit")).click();
        driver.quit();
    }
}
