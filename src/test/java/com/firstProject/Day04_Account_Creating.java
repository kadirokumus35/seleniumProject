package com.firstProject;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Day04_Account_Creating {
    WebDriver driver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void accountCreatingTest() throws InterruptedException {

//        1. Launch browser - DONE IN setUp
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//        3. Verify that home page is visible successfully
        assertTrue(driver.getTitle().equals("Automation Exercise"));
//        4. Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();
//        WebElement signUpLink = driver.findElement(By.partialLinkText("Signup / Login"));
//        signUpLink.click();
//        5. Verify 'New User Signup!' is visible
        assertTrue(driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed());
//        6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(Faker.instance().internet().emailAddress());

//        7. Click 'Signup' button
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
Thread.sleep(3000);
//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        boolean isEnterAccountDisplayed = driver.findElement(By.xpath("//b[.='Enter Account Information']")).isDisplayed();
        assertTrue(isEnterAccountDisplayed);

//        9. Fill details: Title, Name, Email, Password, Date of birth
        //Title
        driver.findElement(By.id("id_gender1")).click();//Mr.

        //Name, Email already entered
Faker faker=new Faker();
        //Password
        driver.findElement(By.id("password")).sendKeys("John.123");
Thread.sleep(3000);
        //Date of birth
        //DropDown --> You can select values by 1. index, 2. value, 3. visible text
        //Day
        //1. Locate the day dropdown web element
        WebElement dayDroDown = driver.findElement(By.xpath("//select[@data-qa='days']"));
        //2. Create Select object
        Select days = new Select(dayDroDown);
        //3. Select the value by using Select Object
        days.selectByIndex(15);

        //Month
        //1. Locate the month dropdown web element
        WebElement monthDroDown = driver.findElement(By.xpath("//select[@data-qa='months']"));
        //2. Create Select object
        Select months = new Select(monthDroDown);
        //3. Select the value by using Select Object
        months.selectByIndex(faker.number().numberBetween(1,12));

        //Year
        //1. Locate the year dropdown web element
        WebElement yearDroDown = driver.findElement(By.xpath("//select[@data-qa='years']"));
        //2. Create Select object
        Select years = new Select(yearDroDown);
        //3. Select the value by using Select Object
        years.selectByValue(String.valueOf(faker.number().numberBetween(1990,2000)));
Thread.sleep(3000);
//        10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.cssSelector("input#newsletter")).click();
Thread.sleep(3000);
//        11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.cssSelector("#optin")).click();
Thread.sleep(3000);
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //First name
        driver.findElement(By.id("first_name")).sendKeys(faker.name().firstName());

//Last name
        driver.findElement(By.id("last_name")).sendKeys(faker.name().lastName());

        //Company
        driver.findElement(By.id("company")).sendKeys(faker.company().name());

        //Address
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());

        //Address2
        driver.findElement(By.id("address2")).sendKeys(faker.address().secondaryAddress());

        //Country
        WebElement countryDropDown = driver.findElement(By.id("country"));
        new Select(countryDropDown).selectByVisibleText("United States");

        //State
        driver.findElement(By.id("state")).sendKeys(faker.address().state());

        //City
        driver.findElement(By.id("city")).sendKeys(faker.address().city());

        //Zipcode
        driver.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());

        //Mobile Number
        driver.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().cellPhone());
Thread.sleep(3000);
//        13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[.='Create Account']")).click();
Thread.sleep(3000);
//        14. Verify that 'ACCOUNT CREATED!' is visible
        assertTrue(driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed());

//        15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //In this step we have an ad pop-up that shows up randomly. Sometimes we won't see it.
        //Because of that we will handle this pop-up inside try-catch block

//        try {
//
//            //try to click on close button on add pop-up
//            //We have here an iFrame to switch in --> We will do this after that topic.
//            driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
//
//        }catch (Exception ignored){
//            System.out.println("Pop-up did not show up!");
//        }
        //To handle the ad pop-up refresh the page and click on "continue one more time"
        driver.navigate().refresh();
      //  driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

//        16. Verify that 'Logged in as username' is visible
        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Logged in as')]")).isDisplayed());

//        17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[.=' Delete Account']")).click();

//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());
        driver.findElement(By.xpath("//a[.='Continue']")).click();

        driver.close();

    }
}