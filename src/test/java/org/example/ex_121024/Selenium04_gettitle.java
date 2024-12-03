package org.example.ex_121024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium04_gettitle {
    public static void main(String[] args) {
        //Headless Mode

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--start-maximized");

        WebDriver chromeDriver =new ChromeDriver(chromeOptions);
        chromeDriver.get("https://app.vwo.com");
        System.out.println("Page title is: " + chromeDriver.getTitle());

    }
}
