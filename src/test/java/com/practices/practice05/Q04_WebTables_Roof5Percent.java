package com.practices.practice05;
import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q04_WebTables_Roof5Percent extends TestBase {

    //We will make a roof of 5% of the height of the earliest built tower.
    //Find how many meters we will build.
/*
    Given
        Go to https://www.techlistic.com/p/demo-selenium-practice.html
    When
        Put all built years into a list
    And
        Calculate min year
    And
        Put all heights into a list
    And
        Calculate the height to build
    Then
        Assert that build height is 25.45 meters
     */
    @Test
    public void webTables_Roof5Percent() {
//        Go to https://www.techlistic.com/p/demo-selenium-practice.html
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

//        Put all built years into a list
        List<WebElement> buildYears = driver.findElements(By.xpath("(//tbody)[2]/tr/td[4]"));

//        Calculate min year
        int minYear = Integer.parseInt(buildYears.get(0).getText());

        for (WebElement w : buildYears) {

            if (minYear > Integer.parseInt(w.getText())) {
                minYear = Integer.parseInt(w.getText());
            }
        }
        System.out.println("minYear = " + minYear);

        //Find the index of minYear
        int minYearIdx = 0;
        for (int i = 0; i < buildYears.size(); i++) {

            if (Integer.parseInt(buildYears.get(i).getText()) == minYear) {
                minYearIdx = i;
            }

        }

        System.out.println("minYearIdx = " + minYearIdx);//2


//        Put all heights into a list
        List<WebElement> heights = driver.findElements(By.xpath("(//tbody)[2]/tr/td[3]"));

//        Calculate the height to build
        int height = Integer.parseInt(heights.get(minYearIdx).getText().replaceAll("\\D", ""));
        double roofHeight = height * 0.05;

//        Assert that build height is 25.45 meters
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String roofToBuild = decimalFormat.format(roofHeight);
        System.out.println(roofToBuild);

        assertEquals("25.45", roofToBuild);


    }

}
