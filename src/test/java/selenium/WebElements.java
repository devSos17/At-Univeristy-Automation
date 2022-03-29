package selenium;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElements{
	
    public WebElement getWebElement(By locator) {
        try {
            WebElement element = Browser.driver.findElement(locator);
            return element;
        } catch (Exception pobjException) {
            System.out.println("The element was ("+ locator +") not located in the page");
            return null;
        }
    }
	
	
    public List<WebElement> getListElements(By locator) {
        try {
            List<WebElement> element = Browser.driver.findElements(locator);
            return element;
        } catch (Exception e) {
            System.out.println("The elements by ("+ locator +") were not located in the page");
            return null;
        }
    }
    
    
    public WebElement getFluentWait(final By locator) {
        try {
            Wait <WebDriver> fluentWait = new FluentWait<WebDriver>(Browser.driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(3L))
                .ignoring(NoSuchElementException.class);
            //Get Web Element and perform action
            WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
              public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
              }
            });
            return element;
        } catch(Exception e) {
            System.out.println("The element was ("+ locator +") not located in the page");
            return null;
        }
    }

    
    public boolean click(final By locator) {
        WebElement element =  getFluentWait(locator);
        WebDriverWait explicitWait = new WebDriverWait(Browser.driver, 10);
        explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        return true;
	  }

    public boolean click(final WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(Browser.driver, 10);
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return true;
	  }
    
    
    public boolean sendKeys(final By locator, String value) {
        WebElement objElement =  getFluentWait(locator);
        WebDriverWait explicitWait = new WebDriverWait(Browser.driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        objElement.clear();
        objElement.sendKeys(value);
        return true;
	  }
    
    public Select selectItem(final By locator, String pValue) {
        WebElement objElement =  getFluentWait(locator);
        WebDriverWait explicitWait = new WebDriverWait(Browser.driver, 10);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return new Select(objElement);
    }
    
    public void waitForElement(final By locator) {
        WebDriverWait explicitWait = new WebDriverWait(Browser.driver, 10);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public void waitForElementClickable(final By locator) {
        WebDriverWait	explicitWait = new WebDriverWait(Browser.driver, 10);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public void WaitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver)
                    .executeScript("return document.readyState")
                    .equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
        wait.until(pageLoadCondition);
    }
    
    public void followLink(final String linktText) {
    	WebElement element = Browser.driver.findElement(By.linkText(linktText));
    	element.click();
    }
    
    public boolean acceptAlert() {
    	WebDriverWait wait = new WebDriverWait(Browser.driver, 3000);
    	wait.until(ExpectedConditions.alertIsPresent());
    	Alert alert = Browser.driver.switchTo().alert();
    	alert.accept();
			return true;
    }
    
    public String getAlertText() {
    	WebDriverWait wait = new WebDriverWait(Browser.driver, 3000);
    	wait.until(ExpectedConditions.alertIsPresent());
    	String alertMessage = Browser.driver.switchTo().alert().getText();
    	return alertMessage;
    }
    
}
