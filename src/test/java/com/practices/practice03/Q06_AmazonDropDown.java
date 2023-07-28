package com.practices.practice03;

import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Q06_AmazonDropDown extends TestBase {
   /*
    Go to https://amazon.com
    Print all the options in the 'Departments' dropdown on the left side of the search box
    Search for each first five options and print titles
     */

    @Test
    public void amazonDropDown() {
//        Go to https://amazon.com
        driver.get("https://amazon.com");

//        Print all the options in the 'Departments' dropdown on the left side of the search box
        List<WebElement> options = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();

//        for (WebElement w : options){
//            System.out.println(w.getText());
//        }
        options.forEach(t -> System.out.println(t.getText()));//Using Lambda is recommended

//        Search for each first five options and print titles
        System.out.println("\nTitles:\n");
        for (int i = 0; i < 5; i++) {
            options = new Select(driver.findElement(By.id("searchDropdownBox"))).getOptions();//To not get StaleElementReferenceException, relocate the web element
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(options.get(i).getText(), Keys.ENTER);
            System.out.println(driver.getTitle());
            driver.navigate().back();
        }
    }
}