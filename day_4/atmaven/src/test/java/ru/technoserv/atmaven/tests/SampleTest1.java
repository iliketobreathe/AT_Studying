package ru.technoserv.atmaven.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest1 {
    String baseUrl = "http://demo.guru99.com/test/newtours/";
    WebDriver driver;

    @BeforeTest
    public void prepareTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public  void test() {
        Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
    }

    @AfterMethod
    public void closeSite() {
        driver.quit();
    }
}
