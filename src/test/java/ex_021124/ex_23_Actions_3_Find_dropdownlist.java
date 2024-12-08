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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

import java.time.Duration;

public class ex_23_Actions_3_Find_dropdownlist {

    WebDriver driver;
    @BeforeTest
    public void browser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Description("Perform Actions select All city from dropdown list")
    @Test
    public void makemytrip() throws InterruptedException{
        driver.get("https://www.makemytrip.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy=\"closeModal\"]"))).click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        WebElement fromCityDropdown = driver.findElement(By.xpath("//label[@for='fromCity']"));
        //WebElement fromCityDropdown =driver.findElement(By.id("fromCity"));
        fromCityDropdown.click();
        List<WebElement> print_name = driver.findElements(By.xpath("//ul[@role='listbox']//li[contains(@class, 'react-autosuggest__suggestion')]//p"));


        for (WebElement listdropdown : print_name){
            System.out.println(listdropdown.getText());//

        }


    }
}
