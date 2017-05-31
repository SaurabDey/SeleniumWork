package com.psl;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {

	//static int fileCounter = 0;
	
	public void shots() throws IOException {
		
		File scrFile = ((TakesScreenshot)Global.driver).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
		
        FileUtils.copyFile(scrFile, new File("E:\\Study\\Selenium\\Selenium webdriver\\snaps\\screenshot.png"));

        
//      File snap = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
//		String fileName = new SimpleDateFormat("yyyyMMddhhmm'.txt'").format(new Date());
//		File des = new File ("E:\\Study\\Selenium\\Selenium webdriver\\snaps\\screenshot"+ fileName+".jpg");
//		FileUtils.copyFile(snap, des);  
        
        
   
        
        
        
//      String fileName = "E:\\Study\\Selenium\\Selenium webdriver\\snaps\\screenshot-" + Screenshot.fileCounter++ + ".png";
//		File fileObj = new File(fileName);
//		while(fileObj.exists())
//		{
//			fileName = fileName.replaceAll(".png", "");
//			fileName = fileName + Screenshot.fileCounter++ + ".png";
//			fileObj = null;
//			fileObj = new File(fileName);
//		}
//		FileUtils.copyFile(scrFile, fileObj);
	}
}
