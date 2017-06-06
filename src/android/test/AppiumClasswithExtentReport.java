package android.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import sun.font.ExtendedTextLabel;

public class AppiumClasswithExtentReport 
{
	RemoteWebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@Test (priority=1,dataProvider="devices")
	public void setup(String foo) throws MalformedURLException
	{
		report = new ExtentReports("Resource\\Report\\Automation.html");
		logger=  report.startTest("Mobile testing");

		logger.log(LogStatus.INFO, "Starting the execution");
		//File application= new File("Resource/TheMallApp.apk");
		
		String browser=foo;
		
		if(browser.equalsIgnoreCase("Mobile"))
		{
		DesiredCapabilities cap = DesiredCapabilities.android();
		cap.setCapability("browserName", "chrome");
		cap.setCapability("deviceName", "Xiaomi");
		cap.setCapability("platformVersion", "5.1.1");
		cap.setCapability("platformName", "Android");
		//cap.setCapability("app", application.getAbsolutePath());
		driver= new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		}
		else if (browser.equalsIgnoreCase("Chrome")) 
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("browserName", "chrome");
			cap.setCapability("platformName", "Vista");
			driver= new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), cap);
			
		} 
		else
		{
			System.out.println("No such browser availble");
		}
		
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		logger.log(LogStatus.PASS, "The application started");
	}
	@Test(priority=2)
	public void browser() throws IOException
	{

		try {
			driver.findElement(By.name("email")).sendKeys("Saurab");
			logger.log(LogStatus.PASS, "Entered the email");

			driver.findElement(By.name("pass221212321")).sendKeys("pass");
			logger.log(LogStatus.PASS, "Entered the password");

			driver.findElement(By.name("login")).click();
			logger.log(LogStatus.PASS, "Clicked on login button");

		} catch (Exception e) {
			screenshot("Login Page");
			
			logger.log(LogStatus.FAIL, "Login functionality Failed");
		}
	}

	//	@Test
	//	public void mobile()
	//	{	
	//		try {
	//			driver.findElement(By.id("com.demo.amanora:id/loginGold")).click();
	//			logger.log(LogStatus.PASS, "Cliked on the desired person");
	//			driver.findElement(By.id("com.demo.amanora:id/MapsLayout")).click();
	//			logger.log(LogStatus.INFO, "Cliked on the next page");
	//		} catch (Exception e) {
	//			logger.log(LogStatus.FAIL, "Login Failed");
	//		}
	//	}
	@AfterTest
	public void teardown() throws InterruptedException
	{		

		driver.quit();

		report.endTest(logger);
		report.flush();
	}
	
	public void screenshot(String  image) throws IOException
	{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("Resource\\Screenshots\\"+image+".png"));
	}
	
	@DataProvider(parallel=true)
	public Object[][] devices()
	{
		Object data[][] = new Object[2][1];

		data[0][0] = "mobile";

		data[1][0] = "chrome";

		return data;
		
	}
}
