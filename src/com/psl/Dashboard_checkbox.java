package com.psl;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Dashboard_checkbox {

	public void checkbox() throws InterruptedException {
		
		
		
		WebElement box=Global.driver.findElement(By.className("metabox-prefs"));
		List<WebElement> elements=box.findElements(By.tagName("label"));
		
		
		//to check second element of the list
		Thread.sleep(5000);
		elements.get(1).click();
		
		//to get the text of the first element
		String name=elements.get(0).getText();
		System.out.println(name);
		
		//to get the lengnt of the List
		int a= elements.size();
		System.out.println(a);
		
		for (WebElement eachElement: elements ) {
			
			System.out.println(eachElement);
		}
		
		
	} 
}
