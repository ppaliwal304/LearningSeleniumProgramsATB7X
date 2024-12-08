package ex_201024;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ex_18_WebTable_Dynamic {

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
    public void test_web_tables1() throws InterruptedException {

        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        driver.manage().window().maximize();

        // Row  - //table[@id="customers"]/tbody/tr
        // Col - //table[@id="customers"]/tbody/tr[1]/td

        int row = driver.findElements(By.xpath("//table[@summary=\"Sample Table\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@summary=\"Sample Table\"]/tbody/tr[1]/td")).size();

        System.out.println("Rows: "+row);
        System.out.println("Columns: "+col);

        // //table[@id="customers"]/tbody/tr[2]/td[3]
        // //table[@id="customers"]/tbody/tr[i]/td[j]

        // first_part   - //table[@id="customers"]/tbody/tr[
        //  i
        // second_part -> ]/td[
        // j
        // third_part->  ]

          String first_part="//table[@summary=\'Sample Table\']/tbody/tr[";
          String second_part="]/td[";
          String third_part="]";

          //i=2-7 because i[1]-header
          //j=1-3

        for(int i=1;i<=row; i++){
            for (int j=1; j<=col; j++){
                String dynamic_xpath= first_part +i +second_part +j+ third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);

                // verify any element and their following and preceding- sibling

                if(data.contains("UAE")){
                    String city_path=dynamic_xpath+"/following-sibling::td";
                    String city_Name=driver.findElement(By.xpath(city_path)).getText();

                    String structure_path=dynamic_xpath+"/preceding-sibling::th";
                    String structure_path_Name=driver.findElement(By.xpath(structure_path)).getText();

                    System.out.println("UAE is country of :" +city_Name);
                    System.out.println("UAE has :" +structure_path_Name);
                }
            }
        }
                }
//
    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}

