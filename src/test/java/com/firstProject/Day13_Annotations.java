package com.firstProject;


import org.testng.annotations.*;


public class Day13_Annotations {
     /*
    @Test: Marks a class or a method as part of the test.
    We have 5 @Before and @After annotations
    Running hierarchy: @BeforeSuite -> @BeforeTest -> @BeforeGroups -> @BeforeClass -> @BeforeMethod
    @Ignore: Ignores/skips the test case
    @Test(enabled = false) disables the test
    @BeforeSuite runs before all tests in this suite.
    @BeforeTest runs before any test method belonging to the classes
    @BeforeGroups runs before grups
    @BeforeClass runs before the first test method in the current class
    @BeforeMethod runs before EACH test method.
    @Test(priority = -1) means it will work before default priorities. Because default priority is 0. If you make the priority less it will work first.

     */


    @BeforeSuite
    public void beforeSuite() {

        System.out.println("Before Suite");

    }

    @AfterSuite
    public void afterSuite() {

        System.out.println("After Suite");

    }

    @BeforeTest
    public void beforeTest() {

        System.out.println("Before Test");

    }

    @AfterTest
    public void afterTest() {

        System.out.println("After Test");

    }

    @BeforeGroups("Lion")
    public void beforeGroups() {

        System.out.println("Before Groups");

    }

    @AfterGroups("Lion")
    public void afterGroups() {

        System.out.println("After Groups");

    }

    @BeforeClass
    public void beforeClass() {

        System.out.println("Before Class");

    }

    @AfterClass
    public void afterClass() {

        System.out.println("After Class");

    }

    @BeforeMethod
    public void beforeMethod() {

        System.out.println("Before Method");

    }

    @AfterMethod
    public void afterMethod() {

        System.out.println("After Method");

    }


    @Test//import org.testng.annotations.Test;
    public void test1() {

        System.out.println("Test 1");

    }

    @Test(groups = "Lion")
    public void test2() {

        System.out.println("Test 2");

    }

    @Test(priority = -2) //@Ignore
    public void test3() {

        System.out.println("Test 3");

    }

    @Test(groups = "Lion")
    public void test4() {

        System.out.println("Test 4");

    }

    @Test(enabled = false)
    public void test5() {

        System.out.println("Test 5");

    }

}
