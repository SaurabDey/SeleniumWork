 package com.start;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import com.psl.Global;
import com.psl.Login_Errormessage;



public class MainCSV_windowResolution_browerZoom {

	static CSVReader reader;
	static CSVWriter writer;
	
	public static void main(String[] args) throws InterruptedException, IOException 
	
	{
		setup();
//--------------write 
		String [] country="India#China#United States".split("#");
		
		writer.writeNext(country);
		writer.close();
//---------------
		String[] row=null;
		
		while ((row=reader.readNext())!=null)
		{
			
		row=reader.readNext();
		
			String userID = row[0];
			String passWord = row[1];
			
			System.out.println("username is "+ userID);
			System.out.println("password is "+passWord);
			
			Login_Errormessage l=new Login_Errormessage();
			l.name(userID,passWord);

			
		}
		
		
		

		teardown();
	}

	public static void setup() throws IOException {
		
		System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
//--------------------------		
		reader= new CSVReader(new FileReader(new File("Resource/CSVreader.csv")));
//--------------------------
		
		writer=new CSVWriter(new FileWriter(new File("Resource/CSVwriter.csv")));
//---------------		
				
		Global.driver=new FirefoxDriver();

		Global.driver.get("http://localhost/wordpress/wp-login.php");

		Global.driver.manage().window().maximize();

		//change the browser width and height as per window resolution
		Global.driver.manage().window().setSize(new Dimension(1280,600));
		Dimension changed =Global.driver.manage().window().getSize();
		System.out.println(changed);
		
		//change the browser zoom in ... zoom out...works only for FF
		WebElement html = Global.driver.findElement(By.tagName("html"));
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));// zoom in
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));// zoom out
		html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
		//implicit wait
		Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void teardown() 
	{
		Global.driver.quit();
		
	}
}
