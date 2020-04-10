package ru.technoserv.atmaven.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class ToolTipTest {
    public String baseUrl = "http://demo.guru99.com/test/social-icon.html";
    WebDriver driver;

    @BeforeTest
    public void createDriver() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void toolTipTest() {
        String expectedTooltip = "Github";

        // Find the Github icon at the top right of the header
        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));

        //get the value of the "title" attribute of the github icon
        String actualTooltip = github.getAttribute("title");

        //Assert the tooltip's value is as expected
        Assert.assertEquals(actualTooltip, expectedTooltip);
    }

    @AfterTest
    public void closeSite() {
        driver.quit();
    }
}