package com.psl;

import java.util.ArrayList;

public class SwitchWindow {
	
	//http://www.popuptest.com/popuptest2.html
	public void window() throws InterruptedException {
		
		
		Global.driver.navigate().to("http://www.popuptest.com/popuptest2.html");
		
		String parentHandle = Global.driver.getWindowHandle();
		
		
		ArrayList<String> tabs2 = new ArrayList<String> (Global.driver.getWindowHandles());
		
		Thread.sleep(5000);
		Global.driver.switchTo().window(tabs2.get(1));
		
		Global.driver.manage().window().maximize();
		
		Thread.sleep(5000);
		Global.driver.switchTo().window(parentHandle);
		Global.driver.manage().window().maximize();
		
		System.out.println("No of windows : "+Global.driver.getWindowHandles().size());
		
//		for (String winHandle : Global.driver.getWindowHandles()) {
//		    Global.driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
//		
//		    Thread.sleep(100);
//		    Global.driver.manage().window().maximize();
//		    Thread.sleep(5000);
//		    Global.driver.close();
//		
//		}
		
		
		
//		Set<String> windowIterator = WebDriverInitialize.getDriver().getWindowHandles();
//        System.err.println("No of windows :  " + windowIterator.size());
	}

}
