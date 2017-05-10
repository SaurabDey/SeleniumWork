package com.psl;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionClass {

	WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
	
		ActionClass ac= new ActionClass();
	
		ac.setup();
		ac.actionMouseHover();
		ac.teardown();

	}

	
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();//Initialize
		driver.manage().window().maximize();		
	}
	public void actionMouseHover() throws InterruptedException
	{
		driver.navigate().to("http://www.guru99.com/selenium-tutorial.html");
		
		Thread.sleep(5000);
		WebElement testing=driver.findElement(By.xpath("//a[text()=' Testing ']"));
		WebElement etesting=driver.findElement(By.xpath("//a[contains(text(),' Enterprise Testing ')]"));
		
		//we may have to clean the browser cookies
		Actions act=new Actions(driver);
		act.moveToElement(testing).moveToElement(etesting);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(.,' Database Testing ')]")));
		act.click().build().perform();
	}
	
	public void actionDragAndDrop() throws IOException, InterruptedException
	{
		
		driver.navigate().to("http://jqueryui.com/droppable/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		WebElement src=driver.findElement(By.id("draggable"));
		
		WebElement dest=driver.findElement(By.id("droppable"));	
		Actions act= new Actions(driver);
		act.dragAndDrop(src, dest).build().perform();
		
		
	}
	
	
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();		
	}

}
