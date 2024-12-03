package org.example.ex_121024;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class Selenium03 {
    @Test
    public void testmethod1() {

        // EdgeOptions -> It will help you set the browser
        // options to browsers
        // window - size
        // headless mode - there is not UI -> advantage - Fast Execution
        // full UI mode - default - UI browser
        // incognito mode - switch
        // start Max
        // add extensions - browsers
        // 100 + others , https , http
        // localstorage, download ?

//    FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("--start-maximized");
//        firefoxOptions.addArguments("--incognito");
//        firefoxOptions.addArguments("--window-size=800,600");
//        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
//        firefoxDriver.get("https://google.com");

        //Type 1: By options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--window-size=800,400");
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        //Type 2: By command
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.google.com");

}
}
