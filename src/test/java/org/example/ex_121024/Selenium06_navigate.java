package org.example.ex_121024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium06_navigate {
    @Test
    public static void navigateurl(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://google.com");
        driver.navigate().refresh();

    }
}
