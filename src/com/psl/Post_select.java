package com.psl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Post_select {
	
	public void select() {
		
		WebElement element=Global.driver.findElement(By.name("action"));
		
		Select s= new Select(element);
		
		s.selectByVisibleText("Move to Trash");
		s.selectByValue("-1");
		s.selectByValue("edit");//s.selectByVisibleText("Edit");//s.selectByIndex(1);

	}
	

}
