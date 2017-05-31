package com.start;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.psl.Dashboard_DragnDrop;
import com.psl.Dashboard_checkbox;
import com.psl.Global;
import com.psl.LoginPageobject;
import com.psl.SwitchWindow;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ATUReportsListener.class, ConfigurationListener.class,  MethodListener.class})

public class MianPageobject {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		setup();
		
		String userID="selenium";
		String passWord="selenium123";
		
		LoginPageobject login= PageFactory.initElements(Global.driver,LoginPageobject.class);
		login.loginPage(userID, passWord);
		
		LoginPageobject log= new LoginPageobject();
		log.loginPage(userID, passWord);
		
		Thread.sleep(5000);
//		SwitchWindow sw= new SwitchWindow();
//		sw.window();
		
		teardown();
		
	}

	public static void setup() throws IOException {
		
		System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");

				
		Global.driver=new FirefoxDriver();

		ATUReports.setWebDriver(Global.driver);
		
		Global.driver.get("http://localhost/wordpress/wp-login.php");

		Global.driver.manage().window().maximize();

		//implicit wait
		Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void teardown() throws InterruptedException 
	{
		
		Global.driver.close();
		
		Thread.sleep(10000);
		
	Global.driver.quit();
	
	
	}
}
