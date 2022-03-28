package pom.openqa;

import org.openqa.selenium.By;

import selenium.Browser;

public class LoginPage extends Browser{

		//Locators
		public static By userField = By.id("userName");
		public static By paswField = By.id("password");
		public static By loginBtn = By.id("login");

		public LoginPage(){
				setBaseUrl("https://demoqa.com/login");
		}

		public boolean logIn(String userName, String password) throws InterruptedException{
				System.out.println("Login");
				// waitt for elements
				waitForElementClickable(userField);
				// enter user
				sendKeys(userField, userName);
				// enter password
				sendKeys(paswField, password);
				// Login
				return click(loginBtn);
		}

}
