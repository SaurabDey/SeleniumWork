package com.psl;

public class navigateClass {

	
	public void navigate() throws InterruptedException
	{
		//Go to post page and come back
		Global.driver.navigate().to("http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html");
		Thread.sleep(3000);
		//Global.driver.navigate().back();
		Global.driver.navigate().to("http://localhost/wordpress/wp-admin");
		
	}
}
