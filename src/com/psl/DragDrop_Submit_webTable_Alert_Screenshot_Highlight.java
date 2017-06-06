package com.psl;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DragDrop_Submit_webTable_Alert_Screenshot_Highlight {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException 
	{

		DragDrop_Submit_webTable_Alert_Screenshot_Highlight ref= new DragDrop_Submit_webTable_Alert_Screenshot_Highlight();
		ref.setUp();
		ref.dragdrop();
		ref.teardown();

	}

	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void dragdrop() throws InterruptedException
	{
		driver.navigate().to("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement from = driver.findElement(By.id("draggable"));
		highlight(from);
		WebElement to = driver.findElement(By.id("droppable"));
		
		Actions drag=new Actions(driver);
		drag.dragAndDrop(from, to);
		drag.perform();
		
		Thread.sleep(5000);
		System.out.println("Draging done");
	}
	public void submit_button() throws InterruptedException
	{
		driver.navigate().to("https://twitter.com/");
		
		WebElement element= driver.findElement(By.xpath("//button[text()='Log In']"));
		element.click();
		WebElement loginID= driver.findElement(By.xpath("//input[@autocomplete='username']"));
		loginID.clear();
		loginID.sendKeys("Saurab");
		WebElement loginpass= driver.findElement(By.xpath("//input[@autocomplete='current-password']"));
		loginpass.clear();
		loginpass.sendKeys("Saurab");
			
		loginpass.submit();
	}

	public void webTable() throws InterruptedException
	{
		driver.navigate().to("http://www.w3schools.com/sql/sql_insert.asp");
		Thread.sleep(5000);

		WebElement element= driver.findElement(By.xpath("//table[@class='w3-table-all notranslate']"));
		List<WebElement> column=element.findElements(By.xpath("tbody/tr"));
		System.out.println("Value in rows is = "+column.size());

		String CustomerID= "88";

		for (int i = 1; i < column.size(); i++)
		{
			WebElement columnName=element.findElement(By.xpath("tbody/tr[1]/th["+i+"]"));
			System.out.println(columnName.getText());
			if (columnName.getText().equals("CustomerID")) {

				for (int j = 2; j < column.size(); j++) {
					
				
			
				WebElement CID=element.findElement(By.xpath("tbody/tr["+j+"]/td[1]"));
				System.out.println(CID.getText());
				if (CID.getText().equals(CustomerID)) 
				{
					WebElement city=element.findElement(By.xpath("tbody/tr["+j+"]/td[5]"));
					System.out.println(city.getText());
					break;
				}
				}
				break;
			}
		}

	}

	public void alert() throws InterruptedException, IOException
	{
		driver.navigate().to("http://jsbin.com/");
		WebElement button=driver.findElement(By.xpath("//input[@type='button'][@value='Go!']"));
		button.click();

		Thread.sleep(5000);
		Alert ref= driver.switchTo().alert();
		System.out.println(ref.getText());
		ref.accept();

	}

	public void screenshot() throws IOException
	{
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		File dest= new File("D:/Workspace/Selenium_Class/Screenshots/rohit.png");
		FileUtils.copyFile(scr, dest);
	}

	
	public void highlight(WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("arguments[0].setAttribute('style', 'background: white;", element);
		
		
	}

	public void teardown()
	{
		System.out.println("execution is compete");
		driver.quit();
	}

}
