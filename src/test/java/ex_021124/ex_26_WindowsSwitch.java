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
import java.util.Set;

public class ex_26_WindowsSwitch {

    WebDriver driver;
    @BeforeTest
    public void browser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Description("Handle windows switch parent to new and new to parent")
    @Test
    public void windowsswitch() throws InterruptedException{
        String url = "https://the-internet.herokuapp.com/windows";
        driver.get(url);
        // Store the handle of the current (parent) window
        String parentwindow = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clicklink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click Here")));
        // Click the link to open a new window
        clicklink.click();
        // Wait for the new window to open
        Thread.sleep(1000);

        // Get all window handles
        Set<String> handlePages= driver.getWindowHandles();

        for (String storePages:handlePages){
            // Switch to the new window
            driver.switchTo().window(storePages);
            if (!storePages.equals(parentwindow)) {
                System.out.println("Page Switch to new Window Successfully");
            }
        }
        Thread.sleep(1000);
        //-------
        // Switch back to the original window
        driver.switchTo().window(parentwindow);
        System.out.println("successfully again back to previuos window");
        Thread.sleep(1000);
        //driver.navigate().back();// its work only for back to "previous page" not change - if page open to a new tab or window
        driver.quit();
    }
}
