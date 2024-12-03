package org.example.ex_121024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium07_Project1 {

    @Test
    public static void project1crudoperation(){

        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("--guest");

        WebDriver driver = new ChromeDriver(chromeoptions);
        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
        WebElement registerAccountFName = driver.findElement(By.id("input-firstname"));
        registerAccountFName.sendKeys("Pushpendra");
        WebElement registerAccountLName = driver.findElement(By.id("input-lastname"));
        registerAccountLName.sendKeys("Paliwal");
        WebElement registerAccountEmail = driver.findElement(By.name("email"));
        registerAccountEmail.sendKeys("ppaliwal3012@yopmail.com");
        WebElement registerAccountNum = driver.findElement(By.name("telephone"));
        registerAccountNum.sendKeys("9140714494");
        WebElement registerAccountpwd = driver.findElement(By.id("input-password"));
        registerAccountpwd.sendKeys("Pass@123");
        WebElement registerAccountcpwd = driver.findElement(By.id("input-confirm"));
        registerAccountcpwd.sendKeys("Pass@123");
        WebElement registerAccountcbox = driver.findElement(By.name("agree"));
        registerAccountcbox.click();
       //Click on continue button
        WebElement registerAccountcbutton = driver.findElement(By.className("btn-primary"));
        registerAccountcbutton.click();
       //Verify account created test
        WebElement registerAccountverifytext = driver.findElement(By.id("content"));
        Assert.assertTrue(registerAccountverifytext.getText().contains("Your Account Has Been Created!"));
        //Assert.assertTrue(driver.getPageSource().contains("Your Account Has Been Created!"));
        driver.quit();
    }
}
