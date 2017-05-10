package autoit;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		System.setProperty("webdriver.ie.driver","Resource/IEDriverServer.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("file:///D:/Workspace/Selenium_Class/Resource/AutoIT/Fileupload.html");
		
		
		driver.findElement(By.xpath("//*[@id='1']")).click();
		
		try {
			Runtime.getRuntime().exec("Resource/AutoIT/FileUploader.exe");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
//		driver.quit();

	}

}
