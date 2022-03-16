package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.Browser;

public class BooksPage extends Browser{

		//Locators
		public static By bookLinks = By.xpath("//div[@class='rt-tr-group']//a");
		public static By addBookBtn = By.id("addNewRecordButton");
		public static By bookName = By.xpath("//div[@id='title-wrapper']//label[@id='userName-value']");

		public BooksPage() {
			setBaseUrl("https://demoqa.com/books");
		}

		public boolean chooseBook(int index){
				return click(getListElements(bookLinks).get(index));
		}

		public boolean addBook(){
				return click(getListElements(addBookBtn).get(1));
		}
		public String getBookName(){
				return getWebElement(bookName).getText();
		}

}
