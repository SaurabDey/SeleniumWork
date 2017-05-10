package android.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class Mobile_Grid 
{
	RemoteWebDriver driver;
	DesiredCapabilities cap;
	@Test (dataProvider="getData")
	public void f(String mob) throws MalformedURLException 
	{
		DesiredCapabilities cap= new DesiredCapabilities();
		if(mob.equals("mobile1")) 
		{
			cap= DesiredCapabilities.android();
			cap.setCapability("browserName", "chrome");
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "Samsung");
			cap.setCapability("platformVersion", "4.4.2");

			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}
		if(mob.equals("chrome")) 
		{
			cap= DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.VISTA);
		
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}


		driver.get("https://www.facebook.com/login/");

		driver.findElement(By.name("email")).sendKeys("sagar29diwanji@gmail.com");

		driver.findElement(By.name("pass")).sendKeys("abcdefgh");

		driver.findElement(By.id("u_0_1")).click();
	}

	@DataProvider(parallel=true)
	public Object[][] getData(){

		Object data[][] = new Object[2][1];

		data[0][0] = "mobile1";

		data[1][0] = "chrome";

		return data;
	}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}

}
