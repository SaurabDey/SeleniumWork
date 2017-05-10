package com.psl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Post_explicitWait {
	
	public void post() {
			
		
		
		WebDriverWait wait= new WebDriverWait(Global.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-posts")));
		
		Global.driver.findElement(By.id("menu-posts")).click();
		
		Global.driver.findElement(By.linkText("Categories")).click();
		
		WebDriverWait wait1=new WebDriverWait(Global.driver, 20);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("tag-name")));
		
		Global.driver.findElement(By.id("tag-name")).sendKeys("Saurab");
		
		Global.driver.findElement(By.id("tag-slug")).sendKeys("20");
		
		WebDriverWait wait2=new WebDriverWait(Global.driver, 20);
		wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("parent")));
		
		new Select(Global.driver.findElement(By.id("parent"))).selectByVisibleText("Uncategorized");
		
		Global.driver.findElement(By.id("tag-description")).sendKeys("adding comments");
		
		Global.driver.findElement(By.id("submit")).click();
		
		System.out.println("Post added successfully");
		
	}

}
