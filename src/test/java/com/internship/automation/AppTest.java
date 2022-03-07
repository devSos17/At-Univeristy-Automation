package com.internship.automation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private WebDriver driver;

    @Before
    public void setup()
    {
        // System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }


    @Test
    public void shouldAnswerWithTrue()
    {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.click();
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals("Selenium - Buscar con Google", driver.getTitle());

    }

    @After
    public void teardown()
    {
    }
}
