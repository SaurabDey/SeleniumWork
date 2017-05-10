package android.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Mobile_WebApp 
{
	RemoteWebDriver driver;
  @Test
  public void f() throws MalformedURLException 
  {
//	  DesiredCapabilities cap= new DesiredCapabilities();
	  DesiredCapabilities cap= DesiredCapabilities.android();
	  cap.setCapability("browserName", "chrome");
	  cap.setCapability("platformName", "Android");
	  cap.setCapability("deviceName", "Jeet");
	  cap.setCapability("platformVersion", "4.4.2");
	  
	  driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	  
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  driver.get("https://www.facebook.com/login/");
		
		driver.findElement(By.name("email")).sendKeys("sagar29diwanji@gmail.com");
		
		driver.findElement(By.name("pass")).sendKeys("abcdefgh");
		
		driver.findElement(By.id("u_0_1")).click();
  }
  

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
