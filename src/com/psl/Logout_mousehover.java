package com.psl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Logout_mousehover {

	public void logout() {
		
		WebElement profile=Global.driver.findElement(By.id("wp-admin-bar-my-account"));
		
		Actions hovering=new Actions(Global.driver);
		hovering.moveToElement(profile).build().perform();
		
		Global.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/ul[2]/li/div/ul/li[3]/a")).click();
		
		//Global.driver.findElement(By.cssSelector("a:contains('Log Out')")).click();
		
		System.out.println("Logged out successfully");
	}
}

//The build() method is always the final method used so that all the listed actions will be compiled into a single step.
//Use the perform() method when executing the Action object we designed 