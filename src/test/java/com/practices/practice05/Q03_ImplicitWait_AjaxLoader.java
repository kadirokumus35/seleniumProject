package com.practices.practice05;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Q03_ImplicitWait_AjaxLoader extends TestBase {
         /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click on Ajax Loader
    And
        Click on "Click Me!" button
    Then
        Assert that button is clicked
    And
        Take screenshot after each step
     */

    @Test
    public void implicitWait_AjaxLoader() throws IOException {
//        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        extentTest.pass("User is on homepage").addScreenCaptureFromPath(captureScreenshotEntirePageAsString());

//        Click on Ajax Loader
        driver.findElement(By.id("button3")).click();
        extentTest.pass("Click on Ajax Loader").addScreenCaptureFromPath(captureScreenshotEntirePageAsString());

//        Click on "Click Me!" button
        waitForClickablility(driver.findElement(By.id("button1")), 5).click();
        extentTest.pass("Click on 'Click Me!' button").addScreenCaptureFromPath(captureScreenshotEntirePageAsString());


//        Assert that button is clicked
        String wellDone = waitForVisibility(driver.findElement(By.xpath("//h4")), 10).getText();
        assertTrue(wellDone.contains("Well Done"));
        extentTest.pass("Assert that button is clicked").addScreenCaptureFromPath(captureScreenshotEntirePageAsString());


//        Take screenshot after each step

    }
}
