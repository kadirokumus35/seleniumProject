package com.firstProject;

import com.utilities.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class Day12_Log4j_2 extends TestBase {


    @Test
    public void test01(){

        Logger logger= LogManager.getLogger(Day12_Log4j_2.class);
        driver.get("https://techproeducation.com");
        logger.info("techpro anasayfaya gidildi");

       // driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
     //   logger.info("sayfada cikan reklam kapatildi");

        Assert.assertFalse(driver.getTitle().contains("Egitim"));
        logger.error("sayfa basligi egitim icermiyor");
    }

}
