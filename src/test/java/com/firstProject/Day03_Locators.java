package com.firstProject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Day03_Locators {
    WebDriver driver;
    @Before
    public void setUp(){
//        @Before method will be used for preconditions
        WebDriverManager.chromedriver().setup();//setting up the driver
        driver = new ChromeDriver();//creating chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//adding implicit wait
        driver.manage().window().maximize();//maximizing the window
    }
    @Test
    public void locatorsTest() throws InterruptedException {
//    When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//    And enter username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
//    And enter password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
//    And click on submit button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
//    Then verify the login is successful
        /*
        STRATEGY:
        https://opensource-demo.orangehrmlive.com/web/index.php/auth/login -> Login URL
        https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index -> After Login URL
        1. if login is successful then  URL must contain dashboard.
           if login is NOT successful then URL should not contains dashboard
        2. if login is successful then <p class="oxd-userdropdown-name" data-v-bdd6d943="">PaulBarak CollingsAvital</p> must be displayed
           otherwise that element should not be displayed
         */
//        verifying the login using URL
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard")); //OR
        Assert.assertFalse(driver.getCurrentUrl().contains("auth"));//after login, URL no longer should contain auth keyword
//        ALTERNATIVELY WE CAN USE A CORE ELEMENT FOR VERIFICATION
//        isDisplayed returns True if the element is on the page. returns false if the element is not on the page
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-name")).isDisplayed());
        Thread.sleep(5000);//waiting for 5 seconds at this point.java wait.
//    Then logout the application
        WebElement theGuy = driver.findElement(By.className("oxd-userdropdown-name"));
        theGuy.click();
        Thread.sleep(5000);//waiting for 5 seconds at this point. java wait.
        WebElement logOutLink = driver.findElement(By.linkText("Logout"));//we can use linkText or partialLinkText. ONLY FULL TEXT for linktext
//        WebElement logOutLink = driver.findElement(By.partialLinkText("ogout"));//we can use FULL TEXT or SUBSTRING
        logOutLink.click();
        Thread.sleep(5000);//waiting for 5 seconds at this point. java wait.
//    Then verify the logout is successful
        /*
        STRATEGY :
        https://opensource-demo.orangehrmlive.com/web/index.php/auth/login -> Login URL
        https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index -> After Login URL
        https://opensource-demo.orangehrmlive.com/web/index.php/auth/login -> After Logout URL
        1. after clicking the logout, if the url contains auth keyword, logout is successful
           after clicking the logout, if the url doesn't contain dashboard keyword , logout is successful
        2. if header is displayed on the page, then logout is successful
        <h5 class="oxd-text oxd-text--h5 orangehrm-login-title" data-v-7b563373="" data-v-358db50f="">Login</h5>
         */
//        NOTE: do not use className when there is a space in the value
//        Assert.assertTrue(driver.findElement(By.className("oxd-text oxd-text--h5 orangehrm-login-title")).isDisplayed());
//        boolean isHeaderDisplayed = driver.findElement(By.tagName("h5")).isDisplayed();
//        Assert.assertTrue(isHeaderDisplayed);
//        I CAN LOCATE ELEMENTS WITH XPATH... MORE COMING
        Assert.assertTrue(
                driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']"))
                        .isDisplayed());
    }
}