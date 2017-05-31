package com.psl;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrame {

	WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
	
		IFrame ac= new IFrame();
		ac.setup();
		ac.iframeSection();
		ac.teardown();
	}
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();//Initialize
		driver.manage().window().maximize();		
	}	
	public void iframeSection()
	{
		driver.navigate().to("http://toolsqa.wpengine.com/iframe-practice-page/");	
		System.out.println(driver.getTitle());	
		//-----------using name--------------
//		driver.switchTo().frame("iframe1");

		//-----------using id-------------
//		driver.switchTo().frame("IF1");

		//-----------using webelement------------
		driver.switchTo().frame(driver.findElement(By.id("IF1")));
		
      driver.findElement(By.name("firstname")).sendKeys("Saurab");
		
      
      driver.switchTo().defaultContent();
		//------------------by index-----which starts from 0, 1, 2--------
		driver.switchTo().frame(1);
		String name=driver.findElement(By.xpath("//div[@id='tabs-1']")).getText();
		System.out.println(name);
		
	}
	
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.quit();		
	}
}
