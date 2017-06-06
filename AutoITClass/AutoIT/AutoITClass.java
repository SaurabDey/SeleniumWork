package com.myclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.POM.DashboardPage;
import com.POM.LoginPage;

public class SeleniumFirstClass {
	WebDriver driver;
	Properties prop;
	@BeforeTest
	public void setup()
	{
		try {
			prop= new Properties();
			File file= new File("resource/utility.properties");
			prop.load(new FileInputStream(file));


			System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://demosite.center/wordpress/wp-login.php");
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void f()
	{
		try {
			LoginPage objlogin= new LoginPage(driver);
			objlogin.login_function("admin","demo123");

			DashboardPage objdash= new DashboardPage(driver);
			String dashboradname= objdash.homepage();

			String dashboardtitle=objdash.gettitle();

			System.out.println(dashboradname + "   " +dashboardtitle);

			WebElement Post= driver.findElement(By.linkText("Posts"));
//			Actions mouse=new Actions(driver);
//			mouse.moveToElement(Post).build().perform();
			Post.click();
			
			WebElement Addnew= driver.findElement(By.linkText("Add New"));
			Addnew.click();

			WebElement Uploadimage= driver.findElement(By.cssSelector("#content-add_media"));
			Uploadimage.click();
			
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='TB_iframeContent']")));
			WebElement SelectFile= driver.findElement(By.id("plupload-browse-button"));
			SelectFile.click();

//upload a document 
			Runtime.getRuntime().exec("resource/AutoIT/FileUpload.exe"+" "+"\\resource\\AutoIT");//Check Fileupload.au3 or 2Worked.PNG where... @WorkingDir = D:\\Workspace\\SeleniumProject .... $CmdLineRaw = \\resource\\AutoIT

						
			Thread.sleep(10000);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();	
	}

}
