package ex_201024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ex_20_WebTable_Dynamic_3 {

    WebDriver driver=new ChromeDriver();


    @Test
    public void Login() throws InterruptedException {

        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        //  element = WebDriverWait(driver, 10).until(
        //        EC.presence_of_element_located((By.ID, "myDynamicElement"))

//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedCondition.presence)
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Hacker@4321");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    @Test

    public void homePage() throws InterruptedException {

        Thread.sleep(3000);

        WebElement table =driver.findElement(By.xpath("//div[@class='orangehrm-container']"));

        List<WebElement> rows =table.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));

        for (WebElement row:rows){
            //WebElement cell=row.findElement(By.xpath("//div[@role='cell']"));
            //System.out.println("in cell loop");
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='cell'][6]")));
            WebElement status=row.findElement(By.xpath(".//div[@role='cell'][6]"));


            //System.out.println(status.getSize());
            String status_message= status.getText();
           // System.out.println(status_message.contains(String(.)));

            if(status_message.equalsIgnoreCase("Terminated")){
                WebElement deleteButton = driver.findElement(By.xpath("//button/i[@class=\"oxd-icon bi-trash\"]"));
                deleteButton.click();
                System.out.println("clicked");
                driver.findElement(By.xpath("//div[@class=\"orangehrm-modal-footer\"]/button[1]")).click();
                break;

            }else{
                System.out.println("not clicked");
            }
        }


    }
}