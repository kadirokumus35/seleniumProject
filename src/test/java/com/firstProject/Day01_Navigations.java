package com.firstProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_Navigations {
    public static void main(String[] args) {

//    Create a new class under : BasicNavigations --> Done
//    Create main method -Done

//    Set Path
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

//    Create chrome driver
            WebDriver driver = new ChromeDriver();

//    Maximize the window
            driver.manage().window().maximize();

//    Open walmart home page https://www.walmart.com/
            driver.get("https://www.walmart.com/");

//    On the same class, Navigate to amazon home page https://www.amazon.com/
            //driver.get("https://www.amazon.com/"); Alternatively we can use navigate().to() method
            driver.navigate().to("https://www.amazon.com/");

//    Navigate back to walmart
            driver.navigate().back();//back(); --> takes driver previous page

//    Navigate forward to amazon
            driver.navigate().forward();//forward(); --> takes the driver forward page

//    Refresh the page
            driver.navigate().refresh();

//    Close/Quit the browser
            //driver.close();
            driver.quit();//quit() method closes all the windows opened in session.
      /*
      What is the difference between get() and navigate().to() methods?
      -Similarities: Both is used for go to URL
      -get() is shorter and easier.
      -get() accepts only URL as String
      -navigate().to() accepts URL as String and URL object
      -navigate() method has more functions such as to(), back(), forward(), refresh()

      What is the difference between close() and quit() methods?
      -close() method closes the last window used by driver
      -quit() method closes all windows used by current driver.
      Prefer quit, because it closes all windows and it is stronger.
       */
    }
}
