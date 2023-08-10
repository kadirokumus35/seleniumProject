package com.firstProject;


import com.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
public class Day10_WebTables extends TestBase {
    //    https://the-internet.herokuapp.com/tables
//
//    Create a class: WebTables
    @Test
    public void printTable() {
        //    Task 1 : Print the entire table
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***PRINT ENTIRE TABLE***");
        String table = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(table);
        List<WebElement> tableElements = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement each : tableElements) {
            System.out.println(each.getText());
        }
//        Assert if the last table element is 'edit delete'
        Assert.assertTrue(tableElements.get(tableElements.size() - 1).getText().equals("edit delete"));
    }

    //    Task 2 : Print All Rows
    @Test
    public void printRows() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("***ALL ROWS***");
        for (WebElement each : allRows) {
            System.out.println(each.getText());
        }
//    Task 3 : Print Last row data only
        System.out.println("LAST ROW DATA : " + allRows.get(allRows.size() - 1).getText());
    }

    //    Task 4 : Print column 5 data in the table body
    @Test
    public void printColumns() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> column5Data = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        System.out.println("***COLUMN 5 DATA***");
        for (WebElement each : column5Data) {
            System.out.println(each.getText());
        }
    }

    //    HOMEWORK : Task 5 : Write a method that accepts 2 parameters
//    Parameter 1 = row number
//    Parameter 2 = column number
//    printData(2,3);  => prints data in 2nd row 3rd column
    public void printData(int rowIndex, int colIndex) {
//    COMPLETE THE CODE
    }

    @Test
    public void printDataTest() {
        printData(2, 3);//jsmith@gmail.com
    }


}
