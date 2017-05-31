package android.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.jna.Platform;

public class AppiumOnTwoDevices implements Runnable
{
	private RemoteWebDriver driver;

	@Test(dataProvider="getData")
	public void f(String mob) throws MalformedURLException 
	{

		if(mob.equals("mobile1")){
			//		  DesiredCapabilities cap= new DesiredCapabilities();
			DesiredCapabilities cap= DesiredCapabilities.android();
			cap.setCapability("browserName", "chrome");
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "Pankaj");
			cap.setCapability("udid", "42038373d07fc000");// check extra section in DOC
			cap.setCapability("platformVersion", "4.2.2");

			driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		}

		if(mob.equals("mobile2")){
			//			  DesiredCapabilities cap= new DesiredCapabilities();
			DesiredCapabilities cap= DesiredCapabilities.android();
			cap.setCapability("browserName", "chrome");
			cap.setCapability("platformName", "Android");
			cap.setCapability("deviceName", "Jeet");
			cap.setCapability("udid", "4df7e41b643bcf29");
			cap.setCapability("platformVersion", "4.4.2");

			driver=new RemoteWebDriver(new URL("http://127.0.0.2:4724/wd/hub"), cap);
		}
		
		if(mob.equals("firefox")){
			//			  DesiredCapabilities cap= new DesiredCapabilities();
			DesiredCapabilities cap= DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(org.openqa.selenium.Platform.VISTA);

			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}

		
		run();

	}

	@DataProvider(parallel=true)
	public Object[][] getData(){

		Object data[][] = new Object[3][1];

		data[0][0] = "mobile1";
		
		data[1][0] = "mobile1";

		data[2][0] = "firefox";

		return data;
	}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}

	@Override
	public void run() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/login/");

		driver.findElement(By.name("email")).sendKeys("sagar29diwanji@gmail.com");

		driver.findElement(By.name("pass")).sendKeys("abcdefgh");

		driver.findElement(By.id("u_0_1")).click();
		
	}

}
