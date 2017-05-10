package com.psl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginwithPropertyfiles {

	WebDriver driver;
	Sheet sheet;
	Workbook excel;
	String name;
	String pass;
	String message;


	public LoginwithPropertyfiles(WebDriver poorwa,  String name,  String pass)
	{

		driver = poorwa;

		this.name=name;
		this.pass=pass;

	}



	public String login() throws InterruptedException, FileNotFoundException, IOException{

		System.out.println("Im here");
		
		Properties pop= new Properties();
		File prop=new  File("Resource/usefull.properties");
		pop.load(new FileInputStream(prop));
		
		WebDriverWait wait5= new WebDriverWait(driver, 80);
		wait5.until(ExpectedConditions.elementToBeClickable(By.id("user_login")));

		
		WebElement userID= driver.findElement(By.id(pop.getProperty("UserID")));
		userID.clear();
		userID.sendKeys(name);
		
		
		WebElement userPass=driver.findElement(By.id(pop.getProperty("PasswordID")));
		userPass.clear();
		userPass.sendKeys(pass);

		
		
		WebElement userClick= driver.findElement(By.id(pop.getProperty("Button")));
		userClick.click();

		Thread.sleep(3000);
		try {

			String error =driver.findElement(By.id("login_error")).getText();
			message = error;
		} 
		catch (Exception e) 
		{

			message= "Logged in succesfully";
		}
		
		
		
		return message;

	}

}
