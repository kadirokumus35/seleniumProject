package com.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {
    //This class is used to run @Before and @After methods automatically in the child class

    //Create these 3 Extent Reports Objects
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentReportsSetup(){
        //These steps must be executed before each class so report generating happens

        // Type a dynamic name for report --> The report will be saved in Reports folder
        String now = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/Reports/extent-reprts" + now + ".html";
        //the html report will be saved in this path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //create extent reports object so the report template can be generated
        extentReports = new ExtentReports();

        // *** Optionally Add Custom System Information ***
        extentReports.setSystemInfo("Project Name","Techpro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Environment","Regression");
        extentReports.setSystemInfo("Team Name","TechPro");
        extentReports.setSystemInfo("SQA","John");

        // *** Optionally Add Document Information ***
        extentHtmlReporter.config().setDocumentTitle("My Extent Report");
        extentHtmlReporter.config().setReportName("My Regression Report");

        //Attach the extentHtmlReporter
        extentReports.attachReporter(extentHtmlReporter);

        //Create extentTest
        extentTest = extentReports.createTest("TechPro Education Regression Report","TechPro team report");

    }


    @AfterClass
    public static void tearDownReport(){
        //flush() method is required for generating the report
        extentReports.flush();
    }


    protected static WebDriver driver;

    @Before//This will run before @Test methods
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
     //   driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After//This will run after @Test methods
    public void tearDown() {
        driver.quit();
    }

    //The method to take screenshot entire page
    public void captureScreenshotEntirePage() throws IOException {
        //1. Step: Convert drive to TakesScreenshot by type casting and use getScreenshotAs() method
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2. Step: Type a dynamic name for screenshots images
        String now = new SimpleDateFormat("yyyyMMddmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir") + "/test-output/Screenshot" + now + ".png";

        //3. Step: Save the image in the path
        FileUtils.copyFile(image, new File(path));
    }

    //The method to take screenshot entire page
    public void captureScreenshotElement(WebElement webElement) throws IOException {
        //1. Step: Convert drive to TakesScreenshot by type casting and use getScreenshotAs() method
        //This step is the only difference between captureScreenshotEntirePage and captureScreenshotElement methods
        File image = webElement.getScreenshotAs(OutputType.FILE);

        //2. Step: Type a dynamic name for screenshots images
        String now = new SimpleDateFormat("yyyyMMddmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir") + "/test-output/ElementScreenshot/Screenshot" + now + ".png";

        //3. Step: Save the image in the path
        FileUtils.copyFile(image, new File(path));
    }

    //This method to take screenshot of entire page and return the path of the screenshot as String. So we can add the path of the screenshot into the extent report
    public String captureScreenshotEntirePageAsString() throws IOException {
        //1. Step: Convert drive to TakesScreenshot by type casting and use getScreenshotAs() method
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //2. Step: Type a dynamic name for screenshots images
        String now = new SimpleDateFormat("yyyyMMddmmss").format(new Date());//This will give us the current time
        String path = System.getProperty("user.dir") + "/test-output/Screenshot" + now + ".png";

        //3. Step: Save the image in the path
        FileUtils.copyFile(image, new File(path));

        //4. Step: return the path of the screenshot
        return path;
    }

}