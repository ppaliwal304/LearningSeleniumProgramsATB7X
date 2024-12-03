package org.example.ex_121024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium09_TextMatching {

    @Test
    public void TextMatching() {

        // Set up the WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the website
        driver.get("https://katalon-demo-cura.herokuapp.com");

        // Locate the "Make Appointment" button
        WebElement containText = driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]"));

        // Wait for the text "Make Appointment" to be present in the element

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Reduced to 10 seconds for efficiency
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-make-appointment")));//wait to find by locator
        wait.until(ExpectedConditions.textToBePresentInElement(containText, "Make Appointment"));// wait to find by ELement

        // Click the "Make Appointment" button
        containText.click();

        // Quit the browser
        driver.quit();
    }
}
