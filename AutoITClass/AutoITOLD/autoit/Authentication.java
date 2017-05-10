package autoit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Authentication {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		System.setProperty("webdriver.ie.driver","Resource/IEDriverServer.exe");
		
		WebDriver driver= new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		
		try {
			Runtime.getRuntime().exec("Resource/AutoIT/authenticationIE");
		} catch (IOException e) {

			e.printStackTrace();
		}
		Thread.sleep(5000);
		driver.get("http://www.engprod-charter.net/");

		driver.quit();
	}

}
