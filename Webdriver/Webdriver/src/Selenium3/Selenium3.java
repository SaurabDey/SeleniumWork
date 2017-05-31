package Selenium3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Selenium3{

	public static void main(String[] args) {
		
		System.out.println("My Name is Saurab");
		
		System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
		System.setProperty("webdriver.firefox.marionette","Resource/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("http://www.seleniumhq.org/download/");
		driver.quit();
		
		driver= new ChromeDriver();
		driver.get("http://www.seleniumhq.org/download/");
		driver.quit();
		
		driver= new InternetExplorerDriver();
		driver.get("http://www.seleniumhq.org/download/");
		driver.quit();
		

	}

}
