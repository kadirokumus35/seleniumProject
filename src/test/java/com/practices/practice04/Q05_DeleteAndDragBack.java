package com.practices.practice04;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Q05_DeleteAndDragBack extends TestBase {
   /*
     Go to URL : https://www.globalsqa.com/demo-site/draganddrop/
     Delete images by clicking delete buttons
     Recycle images by clicking Recycle buttons
     Delete images by drag and drop
     Recycle images by drag and drop
    */

    @Test
    public void deleteAndDragBack() throws InterruptedException {
//        Go to URL : https://www.globalsqa.com/demo-site/draganddrop/
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        //There is an iFrame in the page, we need to switch into related iFrame
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
        driver.switchTo().frame(iFrame);

//        Delete images by clicking delete buttons
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[.='Delete image']"));
        deleteButtons.forEach(WebElement::click);

//        Recycle images by clicking Recycle buttons
        Thread.sleep(1000);
        List<WebElement> recycleButtons = driver.findElements(By.xpath("//a[.='Recycle image']"));
        System.out.println("recycleButtons.size() = " + recycleButtons.size());
        recycleButtons.forEach(WebElement::click);

//        Delete images by drag and drop
        Thread.sleep(1000);
        List<WebElement> images = driver.findElements(By.xpath("//ul[@id='gallery']/li"));//Source
        WebElement trash = driver.findElement(By.id("trash"));//Target
        Actions actions = new Actions(driver);
        images.forEach(t -> actions.pause(100).dragAndDrop(t, trash).perform());

//        Recycle images by drag and drop
        Thread.sleep(1000);
        //We already have source elements in a list
        WebElement gallery = driver.findElement(By.id("gallery"));
        images.forEach(t -> actions.pause(100).dragAndDrop(t, gallery).perform());

        //Find an assertion for this task

    }
}