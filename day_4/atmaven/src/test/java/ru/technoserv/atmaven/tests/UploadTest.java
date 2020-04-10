package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadTest {
    public String baseUrl = "http://demo.guru99.com/test/upload/";
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void prepareTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test
    public void test() {
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        uploadElement.sendKeys("C:/YandexDisk/1.txt");

        driver.findElement(By.id("terms")).submit();

        WebElement resultElement = driver.findElement(By.cssSelector("#res"));
        WebElement resultText = driver.findElement(By.cssSelector("#res > center"));

        driver.findElement(By.name("send")).click();

        wait.until(ExpectedConditions.attributeContains(resultElement, "style", "display: block"));

        Assert.assertTrue(resultText.getText().contains(" successfully"));
    }

    @AfterTest
    public void closeSite() {
        driver.quit();
    }
}