package com.gears42.mk.SeleniumInterview;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowHandlesDriverQuit {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html#google_vignette");
		
		
	/*
		
		
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.id("newWindowBtn")).click();
		for(String windowHandle :driver.getWindowHandles())
		{
			if(!windowHandle.equals(parentWindow))
			{
				driver.switchTo().window(windowHandle);
				driver.manage().window().maximize();
			}
		}
	
		driver.findElement(By.id("firstName")).sendKeys("ABHI");
		Thread.sleep(5000);
		
		*/
		
	//	Exception in thread "main" org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		driver.quit();
		driver.close();
		
	}

}
