package com.start;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.firefox.FirefoxDriver;
import com.psl.Dashboard_DragnDrop;
import com.psl.Global;
import com.psl.Login_Errormessage;
import com.psl.Logout_mousehover;
import com.psl.Post_explicitWait;
import com.psl.Screenshot;




public class MainExcelReadplusFirefoxprofile {




	public static void setup() throws BiffException, IOException, RowsExceededException, WriteException{
		System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
	
		
		File ex=new File("Resource/Data.xls");
		
		Global.excel= Workbook.getWorkbook(ex);

		Global.sheet= Global.excel.getSheet("Sheet1");
//-------------------firefox profile----------------------------------
//		WebDriver driver;
//		ProfilesIni pro=new ProfilesIni();
//		FirefoxProfile profile=pro.getProfile("TestFirefoxprofile");
//		driver=new FirefoxDriver(profile);
//		driver.get("http://www.goibibo.com/");
//		driver.manage().window().maximize();
//		
//		FirefoxProfile profile1=pro.getProfile("Selenium");
//		driver=new FirefoxDriver(profile1);
//		driver.get("http://www.google.com/");
//--------------------------------------------------------------		
		Global.driver=new FirefoxDriver();

		Global.driver.get("http://localhost/wordpress/wp-login.php");

		Global.driver.manage().window().maximize();

		//implicit wait
		Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void tearDown(){
		Global.driver.quit();
		Global.excel.close();
	}

	public static void main(String[] args) throws InterruptedException, IOException, BiffException, RowsExceededException, WriteException {
		setup();


			String userID= Global.sheet.getCell(0, 1).getContents();
			String passWord= Global.sheet.getCell(1, 1).getContents();

			Login_Errormessage l=new Login_Errormessage();
			l.name(userID,passWord);

		//Thread.sleep(2000);
		//Dashboard_checkbox c=new Dashboard_checkbox();
		//c.checkbox();


		//navigateClass n=new navigateClass();

		//n.navigate();

		//Global.driver.switchTo().alert().dismiss();

		Screenshot s=new Screenshot();
		s.shots();

		Dashboard_DragnDrop d=new Dashboard_DragnDrop();
		d.drag();

		Post_explicitWait p=new Post_explicitWait();
		p.post();

		Thread.sleep(5000);

		s.shots();


		Logout_mousehover log=new Logout_mousehover();
		log.logout();



		tearDown();

	}


}
