package com.practices.practice03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q05_GoogleSearch {
    /*
     Create driver and go to http://www.google.com in the before method
     With 3 different test methods:
      -Type "Desktop" in the search box and print the number of results
      -Type "Smartphone" in the search box and print the number of results
      -Type "Laptop" in the search box and print the number of results
     NOTE: Print the result numbers in After method
     Close driver with AfterClass method
      */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @Test
    public void test01() {
        //Type "Desktop" in the search box
        driver.findElement(By.name("q")).sendKeys("Desktop", Keys.ENTER);

    }

    @Test
    public void test02() {
        //Type "Smartphone" in the search box
        driver.findElement(By.name("q")).sendKeys("Smartphone", Keys.ENTER);

    }

    @Test
    public void test03() {
        //Type "Laptop" in the search box
        driver.findElement(By.name("q")).sendKeys("Laptop", Keys.ENTER);

    }

    @After
    public void afterMethod() {
        // Print the number of results
        System.out.println(driver.findElement(By.id("result-stats")).getText().split(" ")[1]);
        driver.close();
    }

}