package com.gears42.mk.SeleniumInterview;

import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrokenImages {
	
	@Test
	public void brokenImageCode() throws InterruptedException
	{
		
		
		//
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/broken-images");
		
		Thread.sleep(5000);
		
		
		List<WebElement> images =driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		for(WebElement image :images)
		{
			@SuppressWarnings("deprecation")
			@Nullable
			String imageURL = image.getAttribute("src");
			
			
			if(imageURL==null || imageURL.isEmpty())
			{
				System.out.println("Image is not configured properly");
				continue;
			}
			else
			{
				try
				{
						URL url = new URL(imageURL);
					    URLConnection urlConnection  = url.openConnection();
					    HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
					    httpURLConnection.setConnectTimeout(3000);
					    httpURLConnection.connect();
					    
					    if(httpURLConnection.getResponseCode() == 200)
					    {
					    	System.out.println(imageURL  + "-" +httpURLConnection.getResponseCode()+ "-" + httpURLConnection.getResponseMessage());
					    }
					    else
					    {
					    	System.err.println(imageURL  + "-" +httpURLConnection.getResponseCode()+ "-" + httpURLConnection.getResponseMessage());
					    	
					    }
				 } 
				catch(Exception e)
				{
					System.err.println(imageURL);
				}
			}
			
		//	driver.quit();
		}
		}
		
		
}
		
		
		

