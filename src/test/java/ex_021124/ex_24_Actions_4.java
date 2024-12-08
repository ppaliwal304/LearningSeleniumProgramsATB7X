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

public class ex_24_Actions_4 {

    WebDriver driver;
    @BeforeTest
    public void browser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Description("Perform Actions with Shift Keys up and down")
    @Test
    public void spicejet() throws InterruptedException{
        String url = "https://www.spicejet.com";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       // WebElement fisrtname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='to-testID-origin'] div:nth-of-type(2)>input")));

//div:nth-of-type(2): Selects the second div child inside the parent div.
//> input: Selects the input element that is a direct child of the second div.

        Actions actions = new Actions(driver);

        //actions.moveToElement(fisrtname).click().build().perform();
        Thread.sleep(1000);
        //actions.keyDown(Keys.SHIFT).sendKeys("jai").keyUp(Keys.SHIFT).perform();
        WebElement Scroll_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a#spinwheel")));
        WebElement Scroll_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#main-container > div > div.css-1dbjc4n.r-14lw9ot > div:nth-child(14)")));

        //Scroll
        //actions.keyDown(Keys.PAGE_DOWN).keyDown(Keys.PAGE_DOWN).perform();// 1-type- normall screen

         actions.sendKeys(Scroll_1,"Keys.PAGE_DOWN").perform();// 2nd-type- scroll for particular element
         Thread.sleep(1000);
         actions.sendKeys(Scroll_2,"Keys.PAGE_DOWN").perform();
        Thread.sleep(1000);


        //driver.quit();
    }
}
