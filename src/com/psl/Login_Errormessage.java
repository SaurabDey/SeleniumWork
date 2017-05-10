package com.psl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login_Errormessage {
	public String message;
	
	@FindBy (id="user_login")
	public WebElement userName;
	
	@FindBy (id="user_pass")
	public WebElement userPass;
	
	public String name(String userID, String passWord) throws InterruptedException {
		
		System.out.println(userID + passWord);
		
	//	WebElement userName=Global.driver.findElement(By.id("user_login"));
		userName.clear();
		userName.sendKeys(userID);

		
		
		//WebElement userPass=Global.driver.findElement(By.id("user_pass"));
		userPass.clear();
		userPass.sendKeys(passWord);

		Global.driver.findElement(By.id("wp-submit")).click();

		try {
			
			WebElement error=Global.driver.findElement(By.id("login_error"));
			if (error.isDisplayed()) 
			{
				System.out.println("Error is "+error.getText());
				
				message = "Error is "+error.getText() ;
			}
		} catch (Exception e) {
			System.out.println("Logged in successfully");
			
			message= "Logged in successfully";
		}
		
		return message;


	}

}
