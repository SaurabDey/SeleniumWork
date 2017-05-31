package com.psl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchTableContent {
	

static WebDriver driver;

	public static void main(String[] args) 
	{
		
		setup();
		Login();
		table();

	}
	
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://localhost:8080/wordpress/wp-login.php");
		driver.manage().window().maximize();
	  }
	
	public static void Login()
	
	{
            driver.findElement(By.id("user_login")).sendKeys("selenium");
            driver.findElement(By.id("user_pass")).sendKeys("selenium123");
            driver.findElement(By.id("wp-submit")).click();
            WebElement my=driver.findElement(By.linkText("Posts"));
            my.click();
           
	  }
	
	public static void table()
	{
		
		WebElement box=driver.findElement(By.className("wp-list-table"));//"wp-list-table widefat fixed posts"//Classname should n have spaces
		List<WebElement> elements=box.findElements(By.xpath("//*[@id='the-list']/tr"));
		System.out.println("Element no is" +elements.size());
																	
		for (int i = 1; i <= elements.size(); i++)
		{
			
			WebElement element=box.findElement(By.xpath("//*[@id='the-list']/tr["+i+"]/td[1]"));
			String content=element.getText();
			System.out.println(content);
			if (content.equals("Adding New Post - Draft")) {
				WebElement elementcheck=box.findElement(By.xpath("//*[@id='the-list']/tr["+i+"]/th[1]/input"));
				elementcheck.click();
				System.out.println("M here");
			} 
		}
	}


}
