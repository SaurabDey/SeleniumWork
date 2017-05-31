package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFirstClass {
	WebDriver driver;
	Workbook ex;
	Sheet sh;
	String username;
	String password;
	
	Properties data;
	public static void main(String[] args) throws BiffException, IOException, InterruptedException 
	
	{
		SeleniumFirstClass ref=new SeleniumFirstClass();
		ref.setUp();
		ref.login();
		ref.teardown();
	
	
	}
	
	
	public void setUp() throws BiffException, IOException, InterruptedException
	{
		driver= new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","Resource/chromedriver.exe");
		//driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
		
//----------------------------property file------------------------------------------------//		
		File use= new File("Resource/useful.properties");
		
		data= new Properties();
		data.load(new FileInputStream(use));
		
		
		driver.get(data.getProperty("URL"));
		
//------------------------------Sreenshot-------------------------------------------//
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
		
        FileUtils.copyFile(scrFile, new File("E:\\Study\\Selenium\\Selenium webdriver\\snaps\\mangesh.png"));
		
//------------------------IFRAME----------------------------------------------------//	
//		driver.get("http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html");
//		
////-----------------------Excel----------------------------------------------------//		
		ex= Workbook.getWorkbook(new File("Resource/data.xls"));
		
		sh= ex.getSheet("Sheet1");
////------------------------excel----------------------------------------------------//
//		driver.switchTo().frame("classFrame");
//		
//		driver.findElement(By.linkText("Deprecated")).click();
//		
//		driver.switchTo().defaultContent();
//		
//	
//		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src,'overview-frame.html')]")));
//		
//		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
//		
//		driver.switchTo().defaultContent();
//		
//		
//		//driver.switchTo().frame("packageFrame");
//		
//		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src,'allclasses-frame.html')]")));
//		
//		driver.findElement(By.linkText("CommandProcessor")).click();
//		
//		driver.switchTo().defaultContent();
//------------------------IFRAME----------------------------------------------------//	
		
	}
	
	public void login() throws IOException
	{
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id(data.getProperty("userID"))));
		
		int rowCount=sh.getRows();
		System.out.println(rowCount);
		
		for (int i = 0; i <sh.getRows(); i++) 
		
		{
			
			username=sh.getCell(0,i).getContents();
			password=sh.getCell(1,i).getContents();
		
		driver.findElement(By.id(data.getProperty("userID"))).sendKeys(username);
		
		driver.findElement(By.id(data.getProperty("passwordID"))).sendKeys(password);
		
		driver.findElement(By.id(data.getProperty("bunID"))).click();
		
		driver.navigate().to(data.getProperty("URL"));
		
		}
		
	}

	public void teardown() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.quit();
		//ex.close();
	}
}
