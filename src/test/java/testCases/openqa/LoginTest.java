package testCases.openqa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pom.openqa.*;
import selenium.Browser;

public class LoginTest {

		// Vars
		public String user;
		public String password;
		public String alertText;
		public LoginPage login;
		public BooksPage books;
		public ProfilePage profile;

    @Before
    public void setup() {
				Browser.connectDriver("chrome");
				user = "devsos17";
				password = "bz@nsc8E";
				login = new LoginPage();
				profile = new ProfilePage();
				books = new BooksPage();
    }

    @After
    public void teardown() {
				Browser.disconnect();
    }

    @Test
    public void testAddBook() {
				try {
						// -- LoginPage
						// login (Login)
						login.goToBaseUrl();
						assertTrue(login.logIn(user, password));
						// -- ProfilePage
						// correctly logged in (Profile)
						assertEquals(user, profile.getUserLabel());
						// Press Bookstore button
						assertTrue(profile.goToBookStore());
						// -- BooksPage
						// Select first Book
						assertTrue(books.chooseBook(0));
						String bookName = books.getBookName();
						// Add book 
						assertTrue(books.addBook());
						// Pass alert 
						books.acceptAlert();
						// -- ProfilePage
						// Go to profile
						profile.goToBaseUrl();
						// Chek if book added
						assertEquals(bookName, profile.getBookText(0));
						// PASS
				} catch(InterruptedException e){
						System.out.print("Test Failed, procces interrupted: "+ e.getMessage());
						fail();
				} catch(Exception e){
						System.out.print("Test Failed, Exception: "+ e.getMessage()+"; happend");
						fail();
				}

    }

}
