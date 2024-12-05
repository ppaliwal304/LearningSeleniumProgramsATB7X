package ex_201024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ex_11_SVG {

  WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guests");
        driver = new ChromeDriver();
    }
    @Description("Find SVG icon and click on it after that verify results")
    @Test

    public void svgelement(){
        driver.get("https://www.flipkart.com");
       driver.findElement(By.name("q")).sendKeys("macmini");

       //Click on SVG
       List<WebElement> svgIcon = driver.findElements(By.xpath("//*[name()='svg']"));
        svgIcon.get(0).click();

        List<WebElement> resultTitle = driver.findElements(By.xpath("//div[contains(@data-id,\"CPU\")]/div/a[2]"));
        for (WebElement title: resultTitle){
            System.out.println(title.getText());
        }



    }
}
