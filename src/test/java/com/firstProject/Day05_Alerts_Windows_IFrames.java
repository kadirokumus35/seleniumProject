package com.firstProject;


import com.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
public class Day05_Alerts_Windows_IFrames extends TestBase {
    @Test
    public void alertWindowsIframeTest1(){
//        Given Go to https://testpages.herokuapp.com/styled/frames/frames-test.html
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
//        Then Assert that "Left List Item 29" is the last element in the "Left"
        /*
        Left List Item 29 element is inside an iframe.
        driver must be switch in this iframe first
        Otherwise driver can not find that element
        1. index -> driver.switchTo().frame(0)
        2. id or name ->  driver.switchTo().frame("left")
        3. webelement > driver.switchTo().frame(  driver.findElement(By.xpath("//frame[@name='left']"))  );
         */
        driver.switchTo().frame("left");// switching the frame by name
        //getting all list items in this iframe
        List<WebElement> leftFrameListItems =  driver.findElements(By.xpath("//li"));
        for (WebElement each : leftFrameListItems){
            System.out.println(each.getText());
        }
        WebElement lastLeftItem = leftFrameListItems.get(leftFrameListItems.size()-1);
        Assert.assertEquals("Expected and Actual Not Equal","Left List Item 29",lastLeftItem.getText());//message will only show up if test case fails
//        And Assert that "Middle List Item 39" is the last element in the "Middle"
        /*
        NOTE1: at this point driver is in the left frame
        so it cannot see anything outside of that frame
        and we must switch to the middle frame to work the elements in the middle frame
        1. index -> driver.switchTo().frame( )
        2. id or name ->  driver.switchTo().frame("middle")
        3. webelement > driver.switchTo().frame(  driver.findElement(By.xpath("//frame[@name='left']"))  );

        NOTE2: We can switch parent to child, or child to parent direction.
        We cannot directly switch to the siblings
        In this case, we need to go to default content/parent frame, then go to the middle child from that parent


         */
//        going to the default content
        driver.switchTo().defaultContent();
//        going to the middle frame
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='middle']"));
        driver.switchTo().frame(middleFrame);//switching by webelement
        // getting all middle frame elements
        List<WebElement> middleFrameListItems = driver.findElements(By.xpath("//li"));
        for (WebElement each : middleFrameListItems){
            System.out.println(each.getText());
        }
        String lastItemText = middleFrameListItems.get(middleFrameListItems.size()-1).getText();
        Assert.assertEquals("Expected and Actual Not Equal","Middle List Item 39",lastItemText);
    }
}