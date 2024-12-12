package ex_021124;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ex_28_Relative_Locators_1 {

    WebDriver driver;
    @BeforeTest
    public void browser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Description("Verify RL")
    @Test
    public void relativeLocatorstext() throws InterruptedException {

        // toRightOf
        // toLeftOf
        // Above
        // below
        // near

        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();
//        WebElement span_element = driver.findElement(By.xpath("//span[normalize-space()='Years of Experience']"));
//        driver.findElement(with(By.id("exp-2")).toRightOf(span_element)).click();

        driver.findElement(with(By.id("exp-1")).toLeftOf(By.id("exp-2"))).click();
        driver.findElement(with(By.id("datepicker")).below(By.id("exp-2"))).sendKeys("23-12-24");


        Thread.sleep(5000);

    }
}
