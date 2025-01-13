package org.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	

	public static WebDriver driver;
	public static WebDriver browserLaunch(String browserName) {
		
		if (browserName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public static void urllaunch(String url) {
		driver.get(url);
	}
	
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	
	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
	}
	
	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public static void implicitlyWait(int secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static void done() {
		System.out.println("Successfully Run Completed");
	}
	
	public static void waitForUrl(int sec, String urlText) {
		WebDriverWait w = new WebDriverWait(driver, sec);
		w.until(ExpectedConditions.urlContains(urlText));
	}
	
	public static void takeScreenShot(String imgName) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ScreenShot\\" + imgName + ".png");
		FileUtils.copyFile(src, des);
	}

	
	
	
}
