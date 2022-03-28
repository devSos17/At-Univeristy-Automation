package pom.openqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.Browser;

public class ProfilePage extends Browser{

		//Locators
		public static By userLabel = By.id("userName-value");
		public static By bookStrBtn = By.id("gotoStore");
		public static By bookLinks = By.xpath("//div[@class='rt-tr-group']//a");
		public static By foo3;

		public ProfilePage() {
				setBaseUrl("https://demoqa.com/profile");
		}

		public String getUserLabel() {
				// wait label
				waitForElementClickable(userLabel);
				// read
				return getWebElement(userLabel).getText();
		}

		public boolean goToBookStore(){
				waitForElementClickable(bookStrBtn);
				return click(bookStrBtn);
		}

		public String getBookText(int index){
				WebElement book = getListElements(bookLinks).get(index);
				return book.getText();
		}

}
