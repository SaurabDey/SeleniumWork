package com.psl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	WebDriver driver;
	public static void main(String[] args) 
	{


		Locators ref= new Locators();
		ref.setUp();
		ref.login();
		ref.tearDown();

	}

	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");

		driver= new ChromeDriver();//initating

		driver.navigate().to("https://www.facebook.com/login");

		driver.manage().window().maximize();
	}
	public void login()
	{
		
		//----------------id----------------------------
//		driver.findElement(By.id("email")).sendKeys("saurab@gmail.com");
//
//		driver.findElement(By.id("pass")).sendKeys("asbcdas");

		//----------------name-----------------------
//		driver.findElement(By.name("email")).sendKeys("saurab@gmail.com");
//
//		driver.findElement(By.name("pass")).sendKeys("asbcdas");
		
		//-------------classname------------------------
//		driver.findElement(By.className("inputtext")).sendKeys("saurab@gmail.com");
//
//		driver.findElement(By.className("inputtext")).sendKeys("asbcdas");
		
		//-------------linktext------------------------
//		driver.findElement(By.linkText("Forgotten account?")).click();
		
		//-------------partiallinktext------------------------
//		driver.findElement(By.partialLinkText("account?")).click();
		
		//--------------tagname---------------
//		driver.findElement(By.tagName("a")).click();
		
		//--------------Relative xpath----------------
		
//		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("Saurab");
		
		//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
		//driver.findElement(By.xpath("//input[@placeholder='Password'][@name='pass']")).sendKeys("password");
//		driver.findElement(By.xpath("//input[@placeholder='Password'  and   @name='pass']")).sendKeys("password");

		driver.findElement(By.xpath("//a[text()=' Testing ']")).click();
		driver.findElement(By.xpath("//a[contains(text(),' Testing ')]")).click();
		driver.findElement(By.xpath("//a[contains(.,' Database Testing ')]")).click();
		
		//-----------absolute xpath-----------
		
//		driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[2]/form/div/div[1]/input")).sendKeys("Saurab");
//	
//		driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div[2]/form/div/div[2]/input")).sendKeys("passwordSaurab");
//		
	//--------css selector------
		
		driver.findElement(By.cssSelector(".inputtext")).sendKeys("Saurab");//for class we use '.' i.e. instead of [class='inputtext']
		driver.findElement(By.cssSelector("#pass")).sendKeys("Saurab"); //for id we use # i.e. instead of [id='email']
		
		//driver.findElement(By.cssSelector("button[name='login']")).click();
		driver.findElement(By.cssSelector("button[name='login'][type='submit']")).click();
		
		driver.findElement(By.cssSelector("input[name='email'][id*='mai']"));//* for contains of email
		
		driver.findElement(By.cssSelector("input[name='email'][id$='ail']"));//$ for ending of email
		
		driver.findElement(By.cssSelector("input[name='email'][id^='ema']"));//^ for starting of email
		
		
		
	}
	
	public void tearDown()
	{
		driver.quit();//close
	}


}
