package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class PopupTest {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    @BeforeClass
    public void createDriver() {
        //Launching the site.
        driver.get("http://demo.guru99.com/popup.php");
    }

    @Test
    public void test() {
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        String mainWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for (String childWindow : allWindows) {

            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();

                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath("/html/body/table/tbody/tr[1]/td/h2")));

                WebElement userIdElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]"));
                WebElement passwordElement = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]"));

                Assert.assertNotEquals(userIdElement.getText(), "");
                Assert.assertNotEquals(passwordElement.getText(), "");

                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

    @AfterMethod
    public void closeSite() {
        driver.quit();
    }
}