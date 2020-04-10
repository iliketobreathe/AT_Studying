package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class DownloadTest {
    public String baseUrl = "http://demo.guru99.com/test/yahoo.html";
    WebDriver driver;

    @BeforeTest
    public void prepareTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void downloadTest() {
        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wgetCommand = "wget -P C:\\YandexDisk --no-check-certificate " + sourceLocation;

        try {
            Process exec = Runtime.getRuntime().exec(wgetCommand);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
            Assert.assertEquals(exitVal, 0);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
    }

    @AfterTest
    public void closeSite() {
        driver.quit();
    }
}