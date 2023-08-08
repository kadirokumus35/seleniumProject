package com.practices.practice04;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class Q04_HardWait extends TestBase {
    //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
    //Click on "click me" button
    //Verify that "Event Triggered"

    @Test
    public void waitTest() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        //Click on "click me" button
        Thread.sleep(4000);
        driver.findElement(By.id("growbutton")).click();//implicit wait will not work here
        //Verify that "Event Triggered"
        assertTrue(driver.findElement(By.id("growbuttonstatus")).isDisplayed());

    }
}