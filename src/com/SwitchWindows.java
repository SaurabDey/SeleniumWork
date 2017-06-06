package com;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchWindows 
{
//WebDriver driver;
//	
//	public SwitchWindows(WebDriver driver)
//	{
//		this.driver = driver;
//	}

	
	public static void main(String args[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","Resource/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
				
				driver.get("http://www.naukri.com/");
		
		List<String> listofwindow= new ArrayList<String>(driver.getWindowHandles());//take inforamion of all the windows
		System.out.println(listofwindow.size());
		Thread.sleep(2000);
		driver.switchTo().window(listofwindow.get(1));
		System.out.println("Title of the window: "+ driver.getTitle());
		driver.switchTo().window(listofwindow.get(1)).close();
		
		Thread.sleep(2000);
		driver.switchTo().window(listofwindow.get(2));
		System.out.println("Title of the window: "+ driver.getTitle());
//		driver.switchTo().window(listofwindow.get(2)).close();
		driver.close();
		
		Thread.sleep(2000);
		driver.switchTo().window(listofwindow.get(0));
		System.out.println("Title of the window: "+ driver.getTitle());
		System.out.println("U of the window: "+ driver.getCurrentUrl());
		
		WebElement search=driver.findElement(By.xpath("//button[contains(text(),'View Salaries')]"));
		search.click();
		Thread.sleep(2000);
		WebElement link= driver.findElement(By.linkText("IIT/IIM Jobs"));
		link.click();
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		listofwindow= new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(listofwindow.get(1));

		System.out.println(driver.getTitle());
		WebElement drop= driver.findElement(By.id("indDDTop"));
		Select d= new Select(drop);
		d.selectByValue("33");
		
		
		
		
//		
	}
}
