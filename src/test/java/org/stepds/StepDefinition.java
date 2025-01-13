package org.stepds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utils.BaseClass;

public class StepDefinition extends BaseClass{
	
	public static void main(String[] args) {
		
		browserLaunch("chrome");
		urllaunch("http://www.facebook.com");
		maximize();
		implicitlyWait(20);
		
		WebElement el = driver.findElement(By.id("email"));
		click(el);
		
		WebElement eee = driver.findElement(By.id("pass"));
		click(eee);
		
		
	}

}
