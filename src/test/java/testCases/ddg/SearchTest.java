package testCases.ddg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.BeforeClass;
import org.junit.Test;

import pom.ddg.*;
import selenium.Browser;

public class SearchTest {

		// Vars
		public static SearchPage searchPage;
		public static ResultsPage resultsPage;

    @BeforeClass
    public static void classSetup() {
				Browser.connectDriver("chrome");
				searchPage = new SearchPage();
				resultsPage = new ResultsPage();
    }

		@Before
		public void setup(){
				// Go to duckDuckgo
				searchPage.goToBaseUrl();
		}

		@Ignore
    @AfterClass
    public static void classTearDown() {
				Browser.disconnect();
    }

    @Test
    public void testNormalQuery() {
				try {
						//Search at DuckDuckGo 
						searchPage.search("selenium");
						// PASS
				} catch(Exception e){
						System.out.print("Test Failed, Exception: "+ e.getMessage()+"; happend");
						fail();
				}

    }

    @Test(timeout = 20000)
    public void testManyQueries() {
				try {
						// Make 5 querys in 5 seconds
						//Search at DuckDuckGo 
						searchPage.search("What is testing");
						resultsPage.search("What is Automation Testing");
						resultsPage.search("How to make selenium work");
						resultsPage.search("Selenium Docker");
						resultsPage.search("Why did i choose CS career");
						// PASS
				} catch(Exception e){
						System.out.print("Test Failed, Exception: "+ e.getMessage()+"; happend");
						fail();
				}

    }

		@Test(expected = Exception.class)
    public void testFirstLink() throws Exception{
				//Search at DuckDuckGo 
				searchPage.search("google");
				resultsPage.clickFirstResult();
				String current = Browser.getCurrentUrl();
				System.out.println(current);
				if(current != "https://duckduckgo.com") 
					throw new Exception("Bad link");

    }

}
