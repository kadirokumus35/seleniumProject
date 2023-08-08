package com.practices.practice04;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q03_ClickTypes extends TestBase {
    //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked
    @Test
    public void clickTypes() throws InterruptedException {

        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons and verify they are all clicked
        //Locate buttons
        WebElement onblur = driver.findElement(By.id("onblur"));
        WebElement onclick = driver.findElement(By.id("onclick"));
        WebElement oncontextmenu = driver.findElement(By.id("oncontextmenu"));
        WebElement ondoubleclick = driver.findElement(By.id("ondoubleclick"));
        WebElement onfocus = driver.findElement(By.id("onfocus"));
        WebElement onkeydown = driver.findElement(By.id("onkeydown"));
        WebElement onkeyup = driver.findElement(By.id("onkeyup"));
        WebElement onkeypress = driver.findElement(By.id("onkeypress"));
        WebElement onmouseover = driver.findElement(By.id("onmouseover"));
        WebElement onmouseleave = driver.findElement(By.id("onmouseleave"));
        WebElement onmousedown = driver.findElement(By.id("onmousedown"));

        //to do right-click and double click we need actions object
        Actions actions = new Actions(driver);
        actions
                .click(onblur)//onblur will not work normal click. we need to click anywhere else after  normal click
                .click(onclick)//This click will not trigger onblur
                .click(onclick)// We need to click on  onclick one more time to trigger it
                .contextClick(oncontextmenu)
                .doubleClick(ondoubleclick)
                .click(onfocus)
                .click(onkeydown)
                .sendKeys(Keys.SPACE)//to trigger onkeydown button we need to press any key
                .click(onkeyup)
                .sendKeys(Keys.SPACE)//to trigger onkeyup button we need to press any key and release
                .click(onkeypress)
                .sendKeys(Keys.SPACE)//to trigger onkeypress button we need to press any key
                .moveToElement(onmouseover)//to trigger onmouseover button we can click on it or hover over it
                .moveToElement(onmouseleave)//to trigger onmouseleave button we must move mouse to another place
                .moveToElement(onmouseover)//to trigger onmouseleave button we move mouse to onmouseover button
                .click(onmousedown)
                .perform();
    }
}