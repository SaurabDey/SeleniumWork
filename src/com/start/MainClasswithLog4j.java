package com.start;

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

public class MainClasswithLog4j 
{
	WebDriver driver;
	Properties prop;
	static Logger logger = Logger.getLogger(MainClasswithLog4j.class);
	@BeforeTest
	public void setup()
	{
//		BasicConfigurator.configure();
		PropertyConfigurator.configure("resource/log4j/log4j.properties");
		logger.debug("This is debug : " );
		logger.info("This is info : " );
		logger.warn("This is warn : ");
		logger.error("This is error : ");
		logger.fatal("This is fatal : ");
		try {
			prop= new Properties();
			File file= new File("resource/utility.properties");
			prop.load(new FileInputStream(file));
			
			
			System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}
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
	}

}
