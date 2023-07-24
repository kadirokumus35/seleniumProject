package com.firstProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxBrowserTest {
    public static void main(String[] args) {
//    Set Path
        System.setProperty("webdriver.firefox.driver","drivers/geckodriver.exe");
        //System.setProperty("webdriver.firefox.driver","drivers/geckodriver");--> MAC users

//    Create gecko driver
        WebDriver driver = new FirefoxDriver();

        //After this step rest is same for all browsers

//    Open Amazon home page https://www.amazon.com/
        String url ="https://www.amazon.com/";
        driver.get(url);

//    Maximize the window
        driver.manage().window().maximize();

//    Close/Quit the browser
        driver.quit();

    }
}
