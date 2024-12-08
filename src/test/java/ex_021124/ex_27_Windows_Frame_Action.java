package ex_021124;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class ex_27_Windows_Frame_Action {

    WebDriver driver;
    @BeforeTest
    public void browser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Description("Handle windows switch parent to new and new to parent")
    @Test
    public void windowsframes() throws InterruptedException{
//        String url = "https://the-internet.herokuapp.com/windows";
//        driver.get(url);
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        // Store the handle of the current (parent) window
        String parentwindow = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement firstListItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.D\\(f\\).Fxw\\(w\\).M\\(-10px\\) > li:nth-of-type(1)")));
        // Click the link to open a new window
        firstListItem.click();
        // Wait for the new window to open
        Thread.sleep(1000);
//
           // Get all window handles
        for (String storePages:driver.getWindowHandles()){

            if (!storePages.equals(parentwindow)) {
              //Switch to the new window
            driver.switchTo().window(storePages);
            System.out.println("Child Window Title: " + driver.getTitle());

            //Switch to iframe
                driver.switchTo().frame("heatmap-iframe");
                WebElement clickmap = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='liqokuxuba']")));
                Thread.sleep(1000);
                clickmap.click();
                Thread.sleep(1000);

                WebElement clickmap1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='lajiwegini']")));
                Thread.sleep(1000);
                clickmap1.click();
                driver.close();
            }
        }
        // Switch back to the original window
        driver.switchTo().window(parentwindow);
        System.out.println("successfully again back to previuos window");
        Thread.sleep(1000);
//        //driver.navigate().back();// its work only for back to "previous page" not change - if page open to a new tab or window
        driver.quit();
    }
}
