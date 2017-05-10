package com.start;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

//import atu.testng.reports.ATUReports;
//import atu.testng.reports.listeners.ConfigurationListener;
//import atu.testng.reports.listeners.MethodListener;
//import atu.testng.reports.logging.LogAs;
//import atu.testng.selenium.reports.CaptureScreen;
//import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;



import com.psl.Alertsbuttons;
import com.psl.Global;
import com.psl.Login_Errormessage;
import com.psl.SwitchWindow;


//@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })

public class miainTestNGExcelWrite_Grid {
	
// static
//	 {
//		 
//		 System.setProperty("atu.reporter.config", "Resource/AUTReport.properties");
//	 }
//	



//	@Test(dataProvider = "test1")
//	public void testPrimeNumberChecker(Integer inputNumber,Boolean expectedResult)
//	{
//		System.out.println(inputNumber + " " + expectedResult);
//	}
//
//	@DataProvider(name = "test1")	
//	public Object[][] data() 
//	{
//		return new Object[][]
//				{ 
//					
//						{ 2, true}, { 6, false }, { 19, true },{ 22, false }, { 23, true } 
//					
//				
//				};
//	}


	@Parameters({"passingValue"})
	
	@Test(description="Login")
	public void readWriteExcel_LOGIN(String para) throws InterruptedException, RowsExceededException, WriteException, IOException {


		System.out.println("parameter passed is :"+para);


		Cell[] cell= Global.sheet.getColumn(0);
		int nofcellinColumn=cell.length;
		System.out.println(nofcellinColumn);

		int noOfRow= Global.sheet.getRows();
		System.out.println(noOfRow);

		for (int i = 1; i < noOfRow; i++) 
		{

			System.out.println("'im here");
			String userID= Global.sheet.getCell(0, i).getContents();
			String passWord= Global.sheet.getCell(1, i).getContents();

			System.out.println(userID + passWord);
			Login_Errormessage l=new Login_Errormessage();
			l.name(userID,passWord);

			String returnedValue=l.message;

			Label l1=new Label(2 , i ,returnedValue); 
			Global.sheet1.addCell(l1);



			Global.driver.navigate().to("http://localhost/wordpress/wp-login.php");
			Thread.sleep(3000);
		}


	}


	@Test(description= "Alert function")
	public void alert(){


		Alertsbuttons s= new Alertsbuttons();
		s.alert();		

	}


	@Test
	public void switching() throws InterruptedException
	{


		Thread.sleep(5000);
		SwitchWindow sw= new SwitchWindow();
		sw.window();

	}



	@AfterTest
	public void afterTest() throws InterruptedException, WriteException, IOException {

		//Thread.sleep(5000);
		Global.excel1.write();
		Global.driver.quit();
		Global.excel.close();
		Global.excel1.close();
	}

	@DataProvider(name="browser")
	public Object[][] browser()
	{
		return new Object[][]
				{
					{"Internet Explorer"}, {"firefox"},{"chrome"}
				};
		
		
	}
	@DataProvider(name="bro")
	public List<String> browser1()
	{
		
		List<String> newList = new ArrayList<String>();
		newList.add("internet explorer");
		newList.add( "firefox");
		newList.add("chrome");
		return newList;
		
	}
	@Test(dataProvider="bro")
	public void test(String bro)
	{
		
		System.out.println("Browser is "+bro);
	}
	
	
	@Parameters({"browserName"})
	@BeforeTest(alwaysRun=true)
	public void beforeTest(String browser) throws BiffException, IOException, RowsExceededException, WriteException {
		
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");


			File temp=new File("Resource/Data.xls");

			Global.excel= Workbook.getWorkbook(temp);

			Global.sheet= Global.excel.getSheet("Sheet1");



			//code to write on excel sheet----------------------------------	
			Workbook readbook = Workbook.getWorkbook(new File("Resource/Data.xls"));

			File writebook=new File("Resource/Data2.xls");
			Global.excel1= Workbook.createWorkbook(writebook, readbook);
			Global.sheet1= Global.excel1.getSheet("Sheet1");
			//----------------------------------------------------------------	
		

	

		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setBrowserName(browser);

		System.out.println(browser);
		Global.driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);

		//Global.driver=new ChromeDriver();
		//--------------------
		ATUReports.setWebDriver(Global.driver);
		//setIndexPageDescription();
		//---------------------
		Global.driver.get("http://localhost/wordpress/wp-login.php");


		Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		Global.driver.manage().window().maximize();

	}




	private void setIndexPageDescription() 
	{
		ATUReports.indexPageDescription = "My Project Description <br/> <b>Can include Full set of HTML Tags</b>";
	}


}
