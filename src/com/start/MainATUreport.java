package com.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.psl.Global;
import com.psl.LoginPageobject;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.reports.ATUReports;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;




//@Listeners({ATUReportsListener.class, ConfigurationListener.class, MethodListener.class})


public class MainATUreport {

	{
		System.setProperty("atu.reporter.config", "Resource/atu.properties");
	}

	WebDriver driver;
	WebElement element;
	@SuppressWarnings("deprecation")
	@Test
	public void f() 
	{
		ATUReports.setTestCaseReqCoverage("This test is mapped to Login Requirement TC_001");
		ATUReports.setAuthorInfo("Saurab Dey","06-April-2014", "1.0");
		driver.get("Http://www.google.com");

		ATUReports.currentRunDescription = "This is a Test Run";



		ATUReports.add("Should open google","saurab","Should open google","actualvalue",false );


//		String userID="selenium";
//		String passWord="selenium123";		
//		LoginPageobject login= PageFactory.initElements(Global.driver,LoginPageobject.class);
//		login.loginPage(userID, passWord);

		ATUReports.add("Step Desc", true);
		ATUReports.add("Step Desc","inputValue",false );

		ATUReports.add("Step Desc","inputValue","expectedValue","actualvalue",false );

	}
	
	   @Test
       public void testNewLogs()
	   {

              ATUReports.add("INfo Step", LogAs.INFO,new CaptureScreen( ScreenshotOf.BROWSER_PAGE));
              ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
             try {
            	  element = driver.findElement(By.xpath("/html/body/div/h1/a"));
			} catch (Exception e) {

	              ATUReports.add("Warning Step", LogAs.WARNING,new CaptureScreen(element));
	              ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
			}
            
       }


	@BeforeTest
	public void beforeTest() 
	{
		driver = new FirefoxDriver();
		ATUReports.setWebDriver(driver);

		setIndexPageDescription();
	}

	@AfterTest
	public void afterTest() 
	{
		driver.close();
	}


	public void setIndexPageDescription() 
	{
		//index page data
		ATUReports.indexPageDescription = "<style>hs{text-align: left;}</style>"
				+"My Project Description </br> "
				+ "<hs><p>You can check the details on consolidated link</p></hs>"
				+ "<hs><p>Checking the inserted datahiedhehkfnncckeb   cbhbchb ecbc u uc ucb cbcbc  c uhfj hj efhj e u  fh h d hohoch  c  u c u e </p></hs>";
	}
}
