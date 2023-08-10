package com.firstProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day12_Log4J2  {

    /*

    dependencies icin apache poie oldugu gibi log4j de de ayni versiyonlar olmali, pom.xml i incele

    log4j.xml dosyasi da resources da olacak=> ayarlari ona gore yapildi


    hem konsolda hemde ayrı bir dosyada adım adım bilgi alırız. souttan farki budur.
    istedigimiz bilgilendirmeyi yazabiliyoruz
    log4j dependices gerekir. zaman bilgisi alinabilir, kalici dosyada bilgiler tutulabilir.


     */
    // Create looger object
    private static Logger logger = LogManager.getLogger(Day12_Log4J2.class.getName());

    @Test
    public void log4J2Test() {
        System.out.println("Logging info...");//println() method is less detailed
        /*
        By default, fatal and error levels will be printed without any configuration
        To see other levels on console we need to do configurations with XML file
         */

        //Use logger object
        logger.fatal("Fatal log ...");//This more detailed log
        logger.error("Error log ...");
        logger.warn("Warn log ...");//This will be printed after configurations
        logger.debug("Debug log ...");//This will be printed after configurations
        logger.info("Info log ...");//This will be printed after configurations


    }
}
