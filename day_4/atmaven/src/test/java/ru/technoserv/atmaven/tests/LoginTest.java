package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    String baseUrl = "http://demo.guru99.com/test/login.html";
    WebDriver driver;
    WebElement email;
    WebElement password;
    WebElement login;

    @BeforeMethod
    public void testPrepare() {
        driver = new ChromeDriver();
        driver.get(baseUrl);

        email = driver.findElement(By.id("email"));
        password = driver.findElement(By.name("passwd"));
        login = driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
    }


    @Test (expectedExceptions = ElementClickInterceptedException.class)
    public void testClick() {
        email.clear();
        password.clear();
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");

        login.click();

        WebElement element = driver.findElement(By.cssSelector("body > div:nth-child(2) > div > div > h3"));

        Assert.assertEquals(element.getText(), "Successfully Logged in...");
    }

    @Test
    public void testSubmit() {
        login.submit();

        WebElement element = driver.findElement(By.cssSelector("body > div:nth-child(2) > div > div > h3"));

        Assert.assertEquals(element.getText(), "Successfully Logged in...");
    }

    @AfterMethod
    public void closeSite() {
        driver.quit();
    }

}