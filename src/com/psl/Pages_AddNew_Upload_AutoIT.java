package com.psl;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Pages_AddNew_Upload_AutoIT
{
	static WebDriver driver;
	static Workbook excel;
	static Sheet sheet;

	public static void main(String[] args) throws BiffException, IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","Resource/chromedriver.exe");
		
		excel=Workbook.getWorkbook(new File("Resource/Data.xls"));
		sheet= excel.getSheet("selenium");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/wordpress/wp-login.php");
		
		
		
		login();
		upload();
		}
	
	public static void login() 
	{
		String userid =sheet.getCell(0, 1).getContents();
		String pass = sheet.getCell(1, 1).getContents();
		
		WebElement ID=driver.findElement(By.id("user_login"));
		ID.clear();
		ID.sendKeys(userid);



		WebElement Password123= driver.findElement(By.name("pwd"));
		Password123.clear();
		Password123.sendKeys(pass);



		WebElement btn=driver.findElement(By.xpath("//*[@id='wp-submit']"));
		btn.click();
	}

	public static void upload() throws InterruptedException, IOException {
		
		driver.findElement(By.linkText("Pages")).click();
		driver.findElement(By.xpath("//a[contains(@href,'post-new.php?post_type=page')]")).click();
		driver.findElement(By.linkText("Set featured image")).click();
		
		driver.findElement(By.linkText("Upload Files")).click();
		System.out.println("Trying to upload");
		
		//Normal way of uploading when text box is available
		//driver.findElement(By.id("__wp-uploader-id-1")).sendKeys("C:\\Users\\Saurab\\Desktop\\village-woman-QK62_l.jpg");
		
		//*****************************************UPLOAD USING AUTO IT*******************************************************
		driver.findElement(By.id("__wp-uploader-id-1")).click();
		Runtime.getRuntime().exec("Resource/AutoIT/upload.exe");
		System.out.println("uploaded");
		//********************************************
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='__wp-uploader-id-0']/div[5]/div/div[2]/a")).click();
		System.out.println("Added");
	}
}


