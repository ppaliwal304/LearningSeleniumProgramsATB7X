package org.example.ex_121024;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium01 {
    public static void main(String[] args) {

        // Basic code for open browser and then close automatic by driver in parallel

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
