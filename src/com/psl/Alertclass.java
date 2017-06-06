package com.psl;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alertclass

{
	WebDriver driver;

	public Alertclass(WebDriver driver)
	{
		this.driver= driver;
		
	}

	public void alert() throws InterruptedException
	{
		
		driver.get("http://jsbin.com/usidix/1");
		
		driver.findElement(By.xpath("/html/body/input")).click();
		
		Thread.sleep(3000);
		
		Alert ok=driver.switchTo().alert();
		ok.accept();
	}
	
}
