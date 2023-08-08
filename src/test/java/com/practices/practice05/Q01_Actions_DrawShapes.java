package com.practices.practice05;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q01_Actions_DrawShapes extends TestBase {
   /*
    Go to http://szimek.github.io/signature_pad/
    Draw the line or shape you want on the screen
    Press the clear button after drawing
    Close the page
     */

    @Test
    public void actions_DrawShapes() {
//        Go to http://szimek.github.io/signature_pad/
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement board = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver).clickAndHold(board);

//        Draw the line or shape you want on the screen

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5, -5);
        }

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0, 5);
        }

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5, 0);
        }

        actions.release().perform();

//        Press the clear button after drawing
        driver.findElement(By.xpath("//button[.='Clear']")).click();

//        Close the page

    }
}
