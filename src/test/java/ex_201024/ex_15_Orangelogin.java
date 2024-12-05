package ex_201024;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ex_15_Orangelogin {

  WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guests");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Description("Enter username and password and verify alert text")
    @Test

    public void orangeLogin() throws NoSuchFieldException, InterruptedException{
        String url ="https://awesomeqa.com/hr/web/index.php/auth/login";
        driver.get(url);
        //JavascriptExecutor js =(JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\'username\']")));

      driver.findElement(By.xpath("//input[@name=\'username\']")).sendKeys("ppaliwal304");
      driver.findElement(By.xpath("//input[@name=\'password\']")).sendKeys("password@123");
      Thread.sleep(1000);
      driver.findElement(By.xpath("//button[text()=\' Login \']")).click();
        // always work "string(.) --if text() has hidden nodes or breaks
        // driver.findElement(By.xpath("//button[contains(string(.),\' Login \']")).click();

        WebElement alertText= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p[text()=\'Invalid credentials\']")));

        // Verify alerttext
        //Assert.assertEquals(alertText.getText(),"Invalid credentials");
        Assert.assertTrue(alertText.getText().contains("Invalid credentials"));
        System.out.println(alertText.getText());
    }
}
