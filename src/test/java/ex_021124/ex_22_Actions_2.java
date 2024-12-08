package ex_021124;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ex_22_Actions_2 {

    WebDriver driver;
    @BeforeTest
    public void browser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Description("Perform Actions with Shift Keys up and down")
    @Test
    public void formFill() throws InterruptedException{
        String url = "https://awesomeqa.com/practice.html";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement fisrtname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name=\'firstname\']")));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(fisrtname,"pushpendra").keyUp(Keys.SHIFT).perform();
    }
}
