package com.psl;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class Dashboard_DragnDrop {

			public void drag(){
			
				//System.out.println("Draging");
			WebElement element=Global.driver.findElement(By.id("dashboard_activity"));
			
			WebElement target1=Global.driver.findElement(By.id("normal-sortables"));
	
			Actions drag=new Actions(Global.driver);
			drag.dragAndDrop(element, target1);
			drag.perform();
			System.out.println("Draging done");
			
			
//			Actions dragging=new Actions(Global.driver);
//			dragging.dragAndDrop(element, target);
//			dragging.perform();
//
//			System.out.println("Draging done");
			
			}
}
