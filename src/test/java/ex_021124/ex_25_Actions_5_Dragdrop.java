package ex_021124;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
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

public class ex_25_Actions_5_Dragdrop {

    WebDriver driver;
    @BeforeTest
    public void browser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Description("Perform Actions Drag and Dropor hold and release the element")
    @Test
    public void dragdrop() throws InterruptedException{
        String url = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dragitemfrom= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#column-a")));
        WebElement dropitemto= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#column-b")));


        Actions actions = new Actions(driver);
        //Drag from A to B
        actions.dragAndDrop(dragitemfrom,dropitemto).perform();//- 1type
        Thread.sleep(1000);
        // Again Drag from B to A
        actions.clickAndHold(dropitemto).moveToElement(dragitemfrom).release(dragitemfrom).build().perform();//-2type
        Thread.sleep(1000);


        //driver.quit();
    }
}
