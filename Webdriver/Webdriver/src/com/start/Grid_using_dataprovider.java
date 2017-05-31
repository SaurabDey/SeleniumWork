package com.start;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Grid_using_dataprovider {
	
	RemoteWebDriver driver;
	
@BeforeTest
public void setup()
{
	try {
		Runtime.getRuntime().exec("cmd /c taskkill /F /IM iexplore.exe /IM chromedriver.exe /IM IEDriverServer.exe /IM chrome.exe /IM Safari.exe /IM firefox.exe /T");
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}
	
//@Parameters("browser")
//@BeforeTest()
  
  @Test(dataProvider="data", priority=1)
	public void beforeTest(Integer n, String browser) throws MalformedURLException 
	{

	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setBrowserName(browser);	
	cap.setPlatform(Platform.VISTA);
	
	driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
	
		f();
	}
  
  public void f() 
  {
	  	driver.get("http://google.com/");
		driver.manage().window().maximize();
		WebElement ID=driver.findElement(By.id("user_login"));
		ID.clear();
		ID.sendKeys("selenium");



		WebElement Password123= driver.findElement(By.name("pwd"));
		Password123.clear();
		Password123.sendKeys("selenium123");



		WebElement btn=driver.findElement(By.xpath("//*[@id='wp-submit']"));
		btn.click();
		
	  
  }


  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  //-----------------------------------Data Provider---------------------------------------//
 	@DataProvider(name="test", parallel=true)	
 	public Object[][] data() 
 	{
 		return new Object[][]
 				{ 
 					
 						new Object[]{ 1, "firefox"},
 						new Object[]{ 2, "chrome"},
 						new Object[]{ 3, "internetexplorer" },
 						new Object[]{ 4, "chrome" }, 
 						new Object[]{ 5, "internetexplorer"} 
 					
 				
 				};
 	}
 	
 	
// 	@Test(dataProvider="test")
// 	public void test(int Number, boolean Result)
// 	{
// 		
// 		System.out.println(Number + " " + Result);
// 	}
// 	

}
