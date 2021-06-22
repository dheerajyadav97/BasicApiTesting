package com.meesho.test;

import org.testng.annotations.*;

public class BaseTest {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Suite execution started...");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Suite execution stopped!!!");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Test execution started...");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Test execution stopped!!!");
    }

//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("Class execution Started...");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("Class execution stopped!!!");
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("Method execution started...");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("Method execution stopped!!!");
//    }
}
