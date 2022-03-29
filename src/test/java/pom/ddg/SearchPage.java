package pom.ddg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.Browser;

public class SearchPage extends Browser{

		//Locators
		public static By searchBar = By.id("search_form_input_homepage");
		public static By searchButton = By.id("search_button_homepage");

		public SearchPage() {
			setBaseUrl("https://duckduckgo.com");
		}


		public boolean search(String query){
				if(! sendKeys(searchBar, query)) return false;
				return click(searchButton);
		}

}
