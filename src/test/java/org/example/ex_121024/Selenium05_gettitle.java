package org.example.ex_121024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium05_gettitle {
        //URL and title verified by testng assertions
  @Test
          public static void getTitle(){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            ChromeDriver driver = new ChromeDriver(chromeOptions);
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            Assert.assertEquals(driver.getTitle(), "CURA Healthcare Service");
            //System.out.println(driver.getTitle());
            Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
            Assert.assertTrue(driver.getPageSource().contains("Atlanta 550")) ;
            //System.out.println(driver.getCurrentUrl());
            driver.quit();

        }

    }

