package com.psl;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import com.google.common.base.Function;
import com.google.common.base.Predicate;





public class FluentWait {

	static WebElement button;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.get("http://www.hdfcbank.com/");

		//Implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//pageLoadTimeout
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

		
/*		
		//Explicit wait
		WebDriverWait wait =new WebDriverWait(driver, 20);
		button=wait.until(ExpectedConditions.elementToBeClickable(By.id("loginsubmit")));
		button.click();
		//Explicit wait
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(button)).click();

*/		
		
		//Fluent Wait
		

		Wait <WebDriver> wait1= new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement foo = wait1.until(new Function<WebDriver, WebElement>() 
										{
											public WebElement apply(WebDriver driver) 
												{
													return driver.findElement(By.id("loginsubmit"));
												}
											}
									);
		
		foo.click();
		//driver.findElement(By.id("loginsubmit")).click();
		
//		//Fluent Wait
//		new org.openqa.selenium.support.ui.FluentWait<WebElement>(button)
//				.withTimeout(3, TimeUnit.SECONDS)
//        		.pollingEvery(100, TimeUnit.MILLISECONDS)
//        		.until(new Predicate<WebElement>() 
//        				{
//        					public boolean apply(WebElement w) 
//        					{
//        						return w.isDisplayed();
//        					}
//        				}
//        				);
//		button.click();
//		
//		//Fluent Wait
//		new org.openqa.selenium.support.ui.FluentWait<WebElement>(button)
//			.withTimeout(3, TimeUnit.SECONDS)
//			.pollingEvery(100, TimeUnit.MILLISECONDS)
//			.withMessage("Element is not present")
//			.ignoring(NoSuchElementException.class)
//		               .until(new Function<WebElement, Boolean>()
//		                    		   {
//			                               public Boolean apply(WebElement w)
//			                               	{
//			                            	   	return w.isDisplayed();
//			                               	}
//		                    		 	}
//		                    		 );
//		button.click();
//
//	
	}

}
