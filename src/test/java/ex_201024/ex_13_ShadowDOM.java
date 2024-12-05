package ex_201024;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


import java.sql.Time;
import java.time.Duration;
import java.util.List;

public class ex_13_ShadowDOM {

  WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guests");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Description("Find shadowDom element and Enter username")
    @Test

    public void svgelement() throws TimeoutException, InterruptedException{
        String url ="https://selectorshub.com/xpath-practice-page";
        driver.get(url);
        JavascriptExecutor js =(JavascriptExecutor)driver;

       //Normal locator not find shadow element
       //WebElement shadowdominput = driver.findElements(By.xpath("//input[@id=\"kils\"]"));


        //Scroll page
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='userName']")));
        WebElement scroll_input_text = driver.findElement(By.xpath("//div[@id='userName']"));
        js.executeScript("arguments[0].scrollIntoView(true);",scroll_input_text);
        Thread.sleep(5000);

        //use Javascript executor--- enter input text
        WebElement shadowdomInput = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"#kils\");");
        shadowdomInput.sendKeys("ppaliwal304");

         Thread.sleep(3000);

        //use javascript executor to-- enter password
       WebElement shadowdompass = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"#pizza\");");
        shadowdompass.sendKeys("Password@123");




    }
}
