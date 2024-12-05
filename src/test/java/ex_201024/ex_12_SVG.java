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

public class ex_12_SVG {

  WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guests");
        driver = new ChromeDriver();
    }
    @Description("Find AllSVGs in map and click on New Delhi")
    @Test

    public void svgelement(){
        String url ="https://www.amcharts.com/svg-maps/?map=india";
        driver.get(url);
        //click on agree button
        WebElement clcick = driver.findElement(By.xpath("//div[@id=\"notice_policy\"]/div[2]/input"));
        clcick.click();

       //Find path of all states
       List<WebElement> stateTitle = driver.findElements(By.xpath("//*[local-name()=\"svg\"]/*[local-name()=\"g\"][7]/*[local-name()=\"g\"]/*[local-name()=\"g\"]/*[local-name()=\"path\"]"));

       for (WebElement title: stateTitle){
            System.out.println(title.getAttribute("aria-label"));
            if(title.getAttribute("aria-label").contains("Delhi")){
                title.click();
                System.out.println("clicked on Delhi");
            }

        }

    }
}
