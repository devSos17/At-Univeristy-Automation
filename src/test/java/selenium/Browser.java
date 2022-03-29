package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser extends WebElements{

		public static WebDriver driver;

		private String baseUrl;

		public void setBaseUrl(String url){
				this.baseUrl = url;
		}

		// default to chrome
		public static WebDriver connectDriver(String browser){
				switch (browser.toUpperCase()) {

				case "CHROME":
						// System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
						// Pulling ChromeDriver from $PATH
						driver = new ChromeDriver();
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						break;
				case "EDGE":
				// For show -> I dont have edge...
						System.setProperty("webdriver.edge.driver", "./src/test/resources/edgedriver");
						driver = new ChromeDriver();
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						break;
				default:
						System.out.println("The browser is "+ browser +" not supported.");
						break;
				}
				return driver;
		}

		public static void disconnect() {
				driver.close();
				driver.quit();
		}

		public static void goTo(String url) {
				driver.get(url);
		}

		public void goToBaseUrl(){
				goTo(this.baseUrl);
		}

		public static String getCurrentUrl(){
			return driver.getCurrentUrl();
		}
}
