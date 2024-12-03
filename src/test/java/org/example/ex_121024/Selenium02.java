package org.example.ex_121024;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium02 {
    // BY TestNG for open multiple browsers and then close automatic in parallel
        @Test
        public void test02(){

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.google.com");
        chromeDriver.quit();

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        driver.quit();

        EdgeDriver driver1 = new EdgeDriver();
        driver1.get("https://www.google.com");
        driver1.quit();
    }
}
