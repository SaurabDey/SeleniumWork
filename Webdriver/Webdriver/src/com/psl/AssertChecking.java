package com.psl;

import org.testng.asserts.*;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

//import static org.junit.Assert.*;//using the Static writing assertTru* will work

public class AssertChecking {
	WebDriver driver;
  @Test
  public void f() 
  {
//	  Assert.assertTrue("Match",driver.getTitle().equalsIgnoreCase("Selenium *"));
//	  assertTrue("content matches", driver.findElement(By.id("user_login")).getText().compareTo("Selenium"));
//	  
//	  Assert.assertFalse("user is abe to login", driver.findElement(By.id("user_login")).getText().isEmpty());
//	  
//	  Assert.assertEquals("USer ane is correct", "Selenium", driver.findElement(By.id("user_login")).getText());;
	  
	  Asserts.check(driver.findElement(By.id("user_login")).getText().isEmpty(), "My TestNG Mesage");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","Resource/chromedriver.exe");
		
	driver=new ChromeDriver();
	  driver.get("http://localhost/wordpress/wp-login.php");
	  driver.findElement(By.id("user_login")).sendKeys("Selenium");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
