package ru.technoserv.atmaven.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class AlertTest {
    public String baseUrl = "http://demo.guru99.com/test/delete_customer.php";
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void prepareTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get(baseUrl);
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();
    }


    @Test
    public void getAlert1() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        Assert.assertEquals(alertMessage, "Do you really want to delete this Customer?");
    }

    @Test
    public void getAlert2() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        String alertMessage2 = alert2.getText();
        alert2.accept();

        Assert.assertEquals(alertMessage2, "Customer Successfully Delete!");
    }

    @AfterMethod
    public void closeSite() {
        driver.close();
    }
}