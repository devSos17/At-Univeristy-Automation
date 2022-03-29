package pom.ddg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.Browser;

public class ResultsPage extends Browser{

		//Locators
		public static By searchBar = By.id("search_form_input");
		public static By searchButton = By.id("search_button");
		public static By results = By.xpath("//div[@data-testid='result']");

		// public ResultsPage() {
		// 	setBaseUrl("https://duckduckgo.com");
		// }


		public boolean search(String query){
				if(! sendKeys(searchBar, query)) return false;
				return click(searchButton);
		}

		public boolean clickFirstResult(){
				return clickResult(1);
		}

		private boolean clickResult(int index) {
				WebElement result =  getListElements(results).get(index);
				System.out.println(result.getText());
				return click(result);
		}

}
