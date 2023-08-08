package com.practices.practice04;



import com.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Q01_ToDoList extends TestBase {
/*
  Given
      Go to http://webdriveruniversity.com/To-Do-List/index.html
  When
      Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
  And
      Strikethrough all todos.
  And
      Delete all todos.
  Then
      Assert that all todos deleted.
​
   */

    @Test
    public void toDoList() throws InterruptedException {
//        Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

//        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        List<String> todolist = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));
        System.out.println("todolist = " + todolist);
        WebElement input = driver.findElement(By.xpath("//input"));

        for (String w : todolist) {
            input.sendKeys(w + Keys.ENTER);
        }

//        Strikethrough all todos.
        List<WebElement> allTodos = driver.findElements(By.xpath("//li"));
        allTodos.forEach(WebElement::click);//Using lambda is recommended

//        Delete all todos
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        deleteButtons.forEach(WebElement::click);


//        Assert that all todos deleted.
        Thread.sleep(500);
        List<WebElement> todosAfterDelete = driver.findElements(By.xpath("//li"));
        assertTrue(todosAfterDelete.isEmpty());

    }
}