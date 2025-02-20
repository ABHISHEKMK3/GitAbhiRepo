package com.gears42.mk.SeleniumInterview;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WhyTypeCastDriver {

	//Properties file = BrowserName=Chrome
	static String browserName = "Firefox";
	
	static WebDriver driver;
	
	@Test
	public void typeCast() throws IOException
	{
		
		switch(browserName)
		{
		case "Chrome":
			driver = new ChromeDriver();
			break;
			
		case "Firefox":
			driver = new FirefoxDriver();
			break;
			
		}
		
	
		
	//	System.setProperty("webdriver.chrome.driver", "D:\\CODE\\SeleniumInterview\\driver\\chromedriver.exe");
		// TODO Auto-generated method stub
		//	 driver = new ChromeDriver();
	        driver.get("https://www.google.com");

    //Need to get the title using JavascriptExecutor

	        JavascriptExecutor js =  (JavascriptExecutor)driver;
	        String title = (String)js.executeScript("return document.title");
	        System.out.println(title);

	        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
	        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	        File target = new File("D:\\CODE\\SeleniumInterview\\Screenshot\\image.png");
	        FileUtils.copyFile(source, target);
	        
	        
	}

}
