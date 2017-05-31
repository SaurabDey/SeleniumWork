package com.psl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPageobject 
{
	
	@FindBy (id="user_login")
	public WebElement userName;
	
	@FindBy (id="user_pass")
    public WebElement userPass;
	
	@FindBy (how=How.ID_OR_NAME, using="wp-submit")
	public WebElement loginbutton;
	
	public void loginPage(String userID,String passWord) 
	{
		enteruser(userID);
		enterpass(passWord);
		pressloginbtn();
		
	}
	
	public void enteruser(String userID) {
		userName.clear();
		userName.sendKeys(userID);
	}
	
	public void enterpass(String passWord) {
		userPass.clear();
		userPass.sendKeys(passWord);
	}
	
	public void pressloginbtn() {
		loginbutton.click();
	
	}
	
	
	
	
}
