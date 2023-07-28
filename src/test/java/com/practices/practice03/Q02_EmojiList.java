package com.practices.practice03;


import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Q02_EmojiList extends TestBase {
    /*
    Given
       Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
       Click on the "Animals and Nature" emoji
    And
       Print emojis under "Animals and Nature" emoji
    And
       Fill the form
    And
       Press the apply button
    Then
       Verify "code" element is displayed
    */

    @Test
    public void test02() {
//        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/\n");

//        Click on the "Animals and Nature" emoji
        //"Animals and Nature" web element is inside an iFrame, we need to switch in that iFrame first
        driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();

//        Print emojis under "Animals and Nature" emoji
        WebElement emojis = driver.findElement(By.xpath("//div[@id='nature']/div"));
        System.out.println("emojis = " + emojis.getText());

        //Go outside the iFrame
        driver.switchTo().defaultContent();

//        Fill the form
        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        List<String> texts = new ArrayList<>(Arrays.asList("This", "iFrame", "example", "looks", "really", "very", "funny", "does", "not", "it", "?"));
        for (int i = 0; i < inputs.size(); i++) {
            inputs.get(i).sendKeys(texts.get(i));
        }

//        Press the apply button
        driver.findElement(By.id("send")).click();

//        Verify "code" element is displayed
        assertTrue(driver.findElement(By.id("code")).isDisplayed());

    }

}