package com.POM;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainClass 
{
	WebDriver driver;
	Properties prop;

	static Logger logger= Logger.getLogger(MainClass.class);//Logger

	@BeforeTest
	public void setup()
	{

//		BasicConfigurator.configure();
		PropertyConfigurator.configure("resource/log4j/log4j.properties");
		
		logger.info("Started Execution");

		try {

		logger.info("Initialiasing property file");
			prop= new Properties();
			File file= new File("resource/utility.properties");
			prop.load(new FileInputStream(file));
		}
		catch (Exception e) 
		{
			logger.error("property file was not found");
			e.printStackTrace();
		}
		logger.info("Initialised the property file");

		try{
		logger.info("Starting Browser");	
			
			System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
			driver= new ChromeDriver();
		logger.info("Deleting Cookies");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		logger.info("Launching URL");	
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();

		} catch (Exception e) 
		{
		logger.error("Something went wrong while launching Browser");
			e.printStackTrace();
		}
		logger.info("Launched the browser");
	}



	@Test
	public void f()
	{

		LoginPage objlogin= new LoginPage(driver);
		objlogin.login_function(prop.getProperty("Username"),prop.getProperty("Password"));

		DashboardPage objdash= new DashboardPage(driver);
		String dashboradname= objdash.homepage();

		String dashboardtitle=objdash.gettitle();

		System.out.println(dashboradname + "   " +dashboardtitle);


	}


	@AfterTest
	public void tearDown()
	{
		driver.quit();	
		logger.info("Browser Closed");
	}

}
