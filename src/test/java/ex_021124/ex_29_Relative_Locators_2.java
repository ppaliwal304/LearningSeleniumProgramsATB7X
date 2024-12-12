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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ex_29_Relative_Locators_2 {

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

        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement span_element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/main/div/div[2]/div[1]/div[1]/div/div[1]/input")));
       // WebElement span_element = driver.findElement(By.xpath("//div[@class=\"search-bar flex gap-[1rem] items-center border border-[#E6E6E6] dark:border-dark_bg focus-within:border-primary bg-[#F7F7FC] dark:bg-[#2B3138] rounded-[1rem] p-[0.5rem] h-full\"]//input"));
        Thread.sleep(5000);
        System.out.println(span_element.isDisplayed());
        Actions actions = new Actions(driver);
        actions.moveToElement(span_element).click().sendKeys("India").perform();

        List<String> allpdata = new ArrayList<>();

        while (true) {
            // Wait for <p> tags to be visible on the current page
            List<WebElement> pTagsOnPage = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//div[@class='flex flex-col']/a/div/p")));

            // Extract text from each <p> tag and add it to the list
            for (WebElement ptag : pTagsOnPage){

                System.out.println(ptag.getText());
                allpdata.add(ptag.getText());
            }
            // Check for the "Next" button in pagination
            List<WebElement> nextButton = driver.findElements(By.xpath("//button[@aria-label='Next Page']"));
            if (nextButton.isEmpty() || !nextButton.get(0).isEnabled()) {
                break; // Exit the loop if no "Next" button
            }
            nextButton.get(0).click();

            // Wait for the next page to load (adjust wait conditions as necessary)
            Thread.sleep(2000); //
        }
        // Print all collected <p> tag data
//        for (String pData : allpdata) {
//            System.out.println(pData);
//        }

       // System.out.println("Total <p> tags data collected: " + allpdata.size());
    }

    }

