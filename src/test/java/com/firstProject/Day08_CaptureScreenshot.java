package com.firstProject;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
public class Day08_CaptureScreenshot extends TestBase {


    @Test
    public void captureScreenshot() throws IOException, InterruptedException {

//        Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");

//        When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        captureScreenshotEntirePage();

//        And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[.='United Kingdom']")).click();
        Thread.sleep(1000);
        captureScreenshotEntirePage();

//       And click on submit button
        driver.findElement(By.cssSelector("input[type='button']")).click();
        Thread.sleep(1000);
        captureScreenshotEntirePage();

//        Then verify the result contains ‘United Kingdom’
        String resultText = driver.findElement(By.cssSelector("#result")).getText();
        assertTrue(resultText.contains("United Kingdom"));
        Thread.sleep(1000);
        captureScreenshotEntirePage();

    }
}