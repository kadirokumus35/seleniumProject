package com.practices.practice04;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Q02_DragAndDrop extends TestBase {
  /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below
    Then
        Verify they are dropped.
  */

    @Test
    public void dragAndDrop() {
//        Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

//        Drag orange elements on proper boxes below
        //Locate sources and target web elements
        //Sources
        WebElement price1 = driver.findElement(By.id("fourth"));
        WebElement price2 = driver.findElement(By.xpath("(//li[@data-id='2'])[2]"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement sales = driver.findElement(By.id("credit1"));

        //Targets
        WebElement debitAmount = driver.findElement(By.id("amt7"));
        WebElement creditAmount = driver.findElement(By.id("amt8"));
        WebElement debitAccount = driver.findElement(By.id("bank"));
        WebElement creditAccount = driver.findElement(By.id("loan"));

        //Create actions object
        Actions actions = new Actions(driver);

        actions
                .dragAndDrop(price1, debitAmount).pause(Duration.ofSeconds(1))
                .dragAndDrop(price2, creditAmount).pause(Duration.ofSeconds(1))
                .dragAndDrop(bank, debitAccount).pause(Duration.ofSeconds(1))
                .dragAndDrop(sales, creditAccount).pause(Duration.ofSeconds(1))
                .perform();


//        Verify they are dropped.
        //Verifying is the "perfect" web element is displayed
        assertTrue(driver.findElement(By.id("equal")).isDisplayed());

    }
}