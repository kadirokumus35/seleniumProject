package com.practices.practice05;

import com.github.javafaker.Faker;
import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class Q02_UploadFile_FillForm extends TestBase {
/*
    Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    Fill the username, password and textArea comment:
    Choose a file and upload it
    Select checkbox, radio item and dropdowns
    Click on submit
    Verify that uploaded file name is on the Form Details.
*/

    @Test
    public void uploadFile_FillForm() {
//        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//        Fill the username, password and textArea comment:
        driver.findElement(By.name("username")).sendKeys(Faker.instance().name().username());
        driver.findElement(By.name("password")).sendKeys(Faker.instance().internet().password());
        driver.findElement(By.name("comments")).clear();
        driver.findElement(By.name("comments")).sendKeys("Hi, this is my application");

//        Choose a file and upload it
        driver.findElement(By.name("filename")).sendKeys(System.getProperty("user.home") + "/Desktop/image.png");

//        Select checkbox, radio item and dropdowns
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@value='cb1']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@value='cb2']"));
        WebElement checkBox3 = driver.findElement(By.xpath("//input[@value='cb3']"));

        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }

        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }

        if (!checkBox3.isSelected()) {
            checkBox3.click();
        }

        WebElement radioButton1 = driver.findElement(By.xpath("//input[@value='rd1']"));
        if (!radioButton1.isSelected()) {
            radioButton1.click();
        }

        WebElement multipleSelectDropDown = driver.findElement(By.xpath("//select[@multiple='multiple']"));
        Select select1 = new Select(multipleSelectDropDown);
        select1.deselectAll();
        select1.selectByValue("ms1");//this will select first option

        WebElement dropDown = driver.findElement(By.name("dropdown"));
        new Select(dropDown).selectByIndex(0);

//        Click on submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

//        Verify that uploaded file name is on the Form Details.
        String fileName = driver.findElement(By.id("_valuefilename")).getText();
        assertEquals("image.png", fileName);

    }
}
