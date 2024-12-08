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

import java.util.List;

public class ex_19_WebTable_Dynamic_2 {

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
    public void test_web_tables2() throws InterruptedException {

        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        driver.manage().window().maximize();

        // This is the way when table data is dynamic used Tag for Row and Column

        // table  xpath-       //table[@summary="Sample Table"]/tbody
        //table  Css Selector- //table[summary='Sample Table'] tbody

        // To find Table
        WebElement table_data = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));

        // To find Row and clolum by tag "tr /td"
        List<WebElement> row_data = table_data.findElements(By.tagName("tr"));
        System.out.println(row_data.get(0).getText());
        System.out.println(row_data.get(1).getText());

        for (int i = 1; i < row_data.size(); i++) {
            List<WebElement> col_data = row_data.get(i).findElements(By.tagName("td"));
            for (WebElement col : col_data) {
                System.out.println(col.getText());
            }
        }
    }
        @AfterTest
        public void closeBrowser(){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.quit();
        }

}

