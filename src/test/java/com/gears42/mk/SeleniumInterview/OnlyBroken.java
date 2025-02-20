package com.gears42.mk.SeleniumInterview;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class OnlyBroken {
	static Set<String> setURLImage = new HashSet<String>();
	static WebDriver driver;
	
	public static void onlyBroken()
	{
		
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/broken-images");
		List<WebElement> images  = driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		      
	for(WebElement image: images)
	{
		  String imageURL =  image.getAttribute("src");
		  System.out.println("image URL : " + imageURL);
		  try
		  {
			  URL url = new URL(imageURL);
			  URLConnection urlConnection =url.openConnection();
			  
			  HttpURLConnection  httpURLConnection  =  (HttpURLConnection)urlConnection;
			  httpURLConnection.setConnectTimeout(3000);
			  httpURLConnection.connect();
			  
			  if(httpURLConnection.getResponseCode() == 200)
			  {
				  setURLImage.add(imageURL);
			  }
			
			  httpURLConnection.disconnect();
			  
		   }
		  catch(Exception e)
		  {
			   System.err.println(imageURL);
	             e.printStackTrace();
		  }
		//  images = driver.findElements(By.tagName("a"));
	  }
	
	 for (String setURL : setURLImage)
	  {
           System.err.println("Broken link: " + setURL);

     } 
	}

	
	public static void main(String[] args)
	{	
		onlyBroken();
		 
	}
	
	
}
