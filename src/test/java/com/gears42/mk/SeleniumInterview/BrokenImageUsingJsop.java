package com.gears42.mk.SeleniumInterview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenImageUsingJsop {

	
	static Set<String> setURLImage = new HashSet<String>();
	//static WebDriver driver;
	
	
	
	@Test
	public static void onlyBroken() throws IOException
	{
		
		Document doc = Jsoup.connect("https://practice.expandtesting.com/broken-images/").get();

		Elements images = doc.select("img");
		for (Element image : images) 
		{
		  String imageURL = image.attr("src"); 
		  if(!imageURL.startsWith("http"))
		  {
			  imageURL = "https://practice.expandtesting.com/broken-images/" +imageURL;
		  }
		  try
		  {
			  URL url = new URL(imageURL);
			  URLConnection urlConnection =url.openConnection();
			  
			  HttpURLConnection  httpURLConnection  =  (HttpURLConnection)urlConnection;
			  httpURLConnection.setConnectTimeout(3000);
			  httpURLConnection.connect();
			  
			  if(httpURLConnection.getResponseCode() != 200)
			  {
				  setURLImage.add(imageURL);
				  System.out.println(imageURL  + "-" +httpURLConnection.getResponseCode()+ "-" + httpURLConnection.getResponseMessage());
			  }
			
			  httpURLConnection.disconnect();  
		   }
		  catch(Exception e)
		  {
			   System.err.println(imageURL);
	             e.printStackTrace();
		  }
		  
		}
		 
	  }
	
	}

