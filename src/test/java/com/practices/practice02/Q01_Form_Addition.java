package com.practices.practice02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Q01_Form_Addition {
        /*
   Given
        Go to url : https://phptravels.com/demo/
   When
        Fill the form
   And
        Click on 'SUBMIT'
   Then
        Assert that the form has been sent
    */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Dynamic wait
    }

    @Test
    public void test01() throws InterruptedException {

//        Go to url : https://phptravels.com/demo/
        driver.get("https://phptravels.com/demo/");

//        Fill the form
        driver.findElement(By.name("first_name")).sendKeys("John");
        driver.findElement(By.name("last_name")).sendKeys("Doe");
        driver.findElement(By.name("business_name")).sendKeys("QA");
        driver.findElement(By.name("email")).sendKeys("john@doe.com");

        //Handle the math result
        Thread.sleep(1000);//For the synchronization issue
        int number1 = Integer.valueOf(driver.findElement(By.id("numb1")).getText());

        Thread.sleep(1000);//For the synchronization issue
        int number2 = Integer.valueOf(driver.findElement(By.id("numb2")).getText());

        String result = String.valueOf(number1+number2);
        driver.findElement(By.id("number")).sendKeys(result);

//        Click on 'SUBMIT'
        driver.findElement(By.id("demo")).click();


//        Assert that the form has been sent
        Thread.sleep(1000);//For the synchronization issue
        String successMessage = driver.findElement(By.xpath("//p[@class='text-center cw']")).getText();
        assertTrue(successMessage.contains("We have sent your demo"));

        driver.quit();

    }
}