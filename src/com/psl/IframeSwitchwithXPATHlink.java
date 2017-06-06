package com.psl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IframeSwitchwithXPATHlink 
{
	WebDriver driver;

	public IframeSwitchwithXPATHlink(WebDriver driver)
	{
		this.driver= driver;
		
	}
	
	public void frame() throws InterruptedException
	{
		
/*		driver.navigate().to("http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html");
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("Deprecated")).click();	
		
		driver.switchTo().defaultContent();
		
		
		Thread.sleep(3000);
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		
*/	
		driver.get("http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html");
		driver.manage().window().maximize();
		driver.switchTo().frame("myid");
		
		driver.switchTo().frame("classFrame");
		
		WebElement menu1 = driver.findElement(By.linkText("Deprecated"));
		menu1.click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
	
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src,'overview-frame.html')]")));
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[contains(@src,'allclasses-frame.html')]")));
		driver.findElement(By.linkText("CommandProcessor")).click();
		
	}
}
