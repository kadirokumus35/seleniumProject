package com.firstProject;

import com.utilities.TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class Day11_JSExecutor extends TestBase {


    /*
    JS ile locate alinmasi istenirse
       JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement date= (WebElement) js.executeScript("return document.getElementByID('buraya elementin id degeri yazilir')");
        date.clear();
        date.sendKeys("5/3/2000");


           String idattributeDegeridate= js.executeScript("return document.getElementByID('buraya elementin id degeri yazilir').id").toString();
        String nameattributeDegeridate= js.executeScript("return document.getElementByID('buraya elementin id degeri yazilir').name").toString();
        String valueattributeDegeridate= js.executeScript("return document.getElementByID('buraya elementin id degeri yazilir').value").toString();


buton rengi degistirmek icin
buttonun locator ı alinip
js objesi olusturup   JavascriptExecutor js= (JavascriptExecutor) driver;
 js.executeScript("arguments[0].style.color='red';",button);

     */



    @Test
    public void jsExecutorTest1() throws InterruptedException {

//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
//        When use click on “Account” link
        Actions actions = new Actions(driver);
//        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));//ALTERNATIVELY
        WebElement accountList =locateElementByJS("nav-link-accountList");
        actions.moveToElement(accountList).perform();
        Thread.sleep(2000);
        WebElement accountLink = driver.findElement(By.linkText("Account"));
//        accountLink.click(); ALTERNATIVELY ( ESPECIALLY WHEN NORMAL CLICK DOESN'T WORK)
        clickByJS(accountLink);
        Thread.sleep(2000);
//        Then verify the page title contains “Your Account”
        Assert.assertTrue(driver.getTitle().contains("Account"));
//        Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic=driver.findElement(By.xpath("//*[text()='Amazon Music']"));
//        actions.moveToElement(amazonMusic).perform();// ALTERNATIVELY
        scrollIntoViewJS(amazonMusic);
        Thread.sleep(2000);
//        And click on it
//        amazonMusic.click();//ALTERNATIVELY
        clickByJS(amazonMusic);
        Thread.sleep(2000);
//        Then verify Amazon Music page is displayed
        Assert.assertTrue(driver.getCurrentUrl().contains("music"));
//        Scroll the page up and down
        scrollAllDownJS();
        Thread.sleep(2000);
        scrollAllUpJS();
        Thread.sleep(2000);
//        search for Pop
        WebElement searchBox = locateElementByJS("navbarSearchInput");
        setValueByJS(searchBox,"Pop");
        Thread.sleep(2000);
        System.out.println(getValueByJS("navbarSearchInput"));//getting the value of that search box
    }
}
