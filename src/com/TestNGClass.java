package com;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;


public class TestNGClass {
	//before Suite
	//before test
	//before class
	//before method
	//priority
	//enable
	//dependsOnMethods
	//dependsOnGroups
	//alwaysRun
	//BeforeGroups
	//Parameter- paraller run
	//Dataprovider- paraller run

//	WebDriver driver;
	//	@BeforeGroups ({"Group1"})
	//	public void group() {
	//		System.out.println("this is before group in diffrent class named ");
	//	}
	

	//	@Test (alwaysRun= true, dependsOnMethods="f2")
	//	public void f() {
	//		System.out.println("this is diffrent class named f");
	//	}
	//	
	//	@Test (priority=1)
	//	public void f1() {
	//		System.out.println("this is diffrent class named f1");
	//	}	
	//	
	//	
	//	@Test (enabled=false)
	//	public void f2() {
	//		System.out.println("this is diffrent class named f2");
	//		
	//		Assert.assertEquals("Saurab", "Sagar");
	//	}
	//	
	//	
	//	@Test ()
	//	public void f3() {
	//		System.out.println("this is diffrent class named f3");
	//	}

//************************************Using PARAMETER*************************	
//	@Parameters ("browerName")
//	@BeforeTest 
//	public void beforeTest(String browser) {
//
//		if (browser.equals("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
//			driver = new ChromeDriver();
//
//		}
//		if (browser.equals("ie"))
//		{
//			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
//			
//		}
//		if (browser.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}

//************************************Using DATAPROVIDER*************************	
//	@DataProvider (name="data", parallel=true)
//	public Object[][] browser()
//	{
//		
//		Object[][] ref= new Object[][]
//				{
//					{1,"ie"},{2, "firefox"},{3, "chrome"}
//			
//				};
//				
//				
//		return ref;
//		
//	}
//	
//	
//	@Test (dataProvider="data")
//	public void f1(Integer number, String browser) throws InterruptedException 
//	{
//		if (browser.equals("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
//			driver = new ChromeDriver();
//
//		}
//		if (browser.equals("ie"))
//		{
//			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
//			driver = new InternetExplorerDriver();
//			
//		}
//		if (browser.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://www.facebook.com/");
//		test();
//		afterTest();
//		
//	}	
//

//************************************Using GRID*************************
	WebDriver driver;
	
	@Test (dataProvider="data")
	public void start( Integer number,String browserName) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
		desiredCapabilities.setBrowserName(browserName);
		
		driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com/");
		test();
	}
	
	@DataProvider (name="data", parallel=true)
	public Object[][] browser()
	{
		
		Object[][] ref= new Object[][]
				{
					{1, "internet explorer"},
					{2, "firefox"},
					{3, "chrome"}
										
				};	
		return ref;
		
	}
	
	public void test() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement id=driver.findElement(By.id("email"));
		id.clear();
		id.sendKeys("saurab");
		
	}
	
	@AfterTest
	public void afterTest() 
	{
		driver.quit();
		System.out.println("this is @AfterTest");
	}

	
	
	
	
}
