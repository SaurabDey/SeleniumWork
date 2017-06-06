package com.psl;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class Alertsbuttons {

	
	public void alert() {

		Global.driver.navigate().to("http://jsbin.com/usidix/1");
		
		 Global.driver.findElement(By.xpath("html/body/input")).click();
		
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    Alert a= Global.driver.switchTo().alert();
	    a.accept();
	
		
	}
}
