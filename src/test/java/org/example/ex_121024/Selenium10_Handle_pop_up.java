package org.example.ex_121024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium10_Handle_pop_up {
    public static void main(String[] args) {

        // Set up the WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //BY cSS Selector
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.commonModal__close")));
        WebElement popupHandle = driver.findElement(By.cssSelector("span.commonModal__close"));

        //BY XPath
        //WebElement popupHandle = driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"commonModal__close\"]")));
        popupHandle.click();
        System.out.println("Closed the pop-up");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
