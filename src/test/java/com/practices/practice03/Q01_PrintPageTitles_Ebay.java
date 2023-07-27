package com.practices.practice03;

import com.firstProject.utilities.TestBase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q01_PrintPageTitles_Ebay extends TestBase {

        /*
         Go to ebay page
         Click on electronics section
         Click on all the images with a Width of 225 and a Length of 225
         Print the page title of each page
         Close the page
          */

    @Test
    public void test01(){
//        Go to ebay page
        driver.get("https://www.ebay.com/");

//        Click on electronics section
        driver.findElement(By.linkText("Electronics")).click();

//        Click on all the images with a Width of 225 and a Length of 225
//        Print the page title of each page
        List<WebElement> images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        System.out.println("images = " + images.size());
        for(int i = 0; i<images.size(); i++){
            images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));//To not have StaleElementReferenceException, locate the web elements one more time
            images.get(i).click();
            System.out.println(i+1+". title: "+driver.getTitle());
            driver.navigate().back();
        }

//        Close the page

    }

}