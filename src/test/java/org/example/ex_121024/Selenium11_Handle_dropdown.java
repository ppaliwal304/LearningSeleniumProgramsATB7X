package org.example.ex_121024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium11_Handle_dropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
// Static Way-- Handle selenium by HTML Tag
        Select select = new Select(dropdownElement);
        //select.selectByIndex(2);
        //select.selectByVisibleText("Option 2");
        select.selectByValue("1");
        System.out.println(select.getFirstSelectedOption().getText());





        //driver.quit();
    }
}
