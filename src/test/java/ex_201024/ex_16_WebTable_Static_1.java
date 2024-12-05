package ex_201024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ex_16_WebTable_Static_1 {

    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }


    @Description("Verify Web Tables")
    @Test
    public void test_web_tables() throws InterruptedException {

        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);
        driver.manage().window().maximize();

        // Row  - //table[@id="customers"]/tbody/tr
        // Col - //table[@id="customers"]/tbody/tr[1]/td

        // Find only one element from table and his company and country name----
        WebElement rowContent = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td[2]"));
        WebElement rowContent1 = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td[2]/following-sibling::td"));
        WebElement rowContent2 = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td[2]/preceding-sibling::td"));

        WebElement rowContent3 = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[1]/th[3]"));
        String headerCountry =rowContent3.getText();
        WebElement rowContent4 = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[1]/th[1]"));
        String headerCompany =rowContent4.getText();

        System.out.println(rowContent.getText());
        System.out.println(rowContent.getText()+ " : "+headerCountry+" : " +rowContent1.getText());
        System.out.println(rowContent.getText() + headerCompany + rowContent2.getText());
        driver.quit();




    }
}