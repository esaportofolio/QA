package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class NegativeTests {
	
	@Test
	public void incorrectUsername() 
	{
		System.out.println("Incorrect Username Test");
		//steps :
		//set and create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//wait for the page to be loaded perfectly
		sleep();
		
		//maximize window page
		driver.manage().window().maximize();
		
		//open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened");
		
		//Element Declaration & Verification visible or not
		String uname = "tomsmith";
		String pword = "SuperSecretPassword!";
		WebElement unamef = driver.findElement(By.id("username"));
		WebElement pwordf = driver.findElement(By.id("password"));
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		WebElement loginbnr = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		
		//fill the username field
		unamef.sendKeys("username");
		sleep();
		
		//fill the password field
		pwordf.sendKeys(pword);
		sleep();
		//click on login button
		loginbtn.click();
		sleep();
		
		//verify url is right
		String aftlgnurl = "https://the-internet.herokuapp.com/login";
		String acturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, aftlgnurl, "Actual url is not the same as url");
	
		//verify message is right
		WebElement errmsg =  driver.findElement(By.xpath("/html//div[@id='flash']"));
		String experru = "Your username is invalid!";
		String acterrmsgu = errmsg.getText();
		sleep();
		
		Assert.assertTrue(acterrmsgu.contains(experru), "Actual Error Message does not contain expected.\nActual: " + acterrmsgu +"\n");
		
		//close browser
		driver.quit();

	}
	
	@Test
	public void incorrectPassword() 
	{
		System.out.println("Incorrect Password Test");
		//steps :
		//set and create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//wait for the page to be loaded perfectly
		sleep();
		
		//maximize window page
		driver.manage().window().maximize();
		
		//open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened");
		
		//Element Declaration & Verification visible or not
		String uname = "tomsmith";
		String pword = "SuperSecretPassword!";
		WebElement unamef = driver.findElement(By.id("username"));
		WebElement pwordf = driver.findElement(By.id("password"));
		WebElement loginbtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		WebElement loginbnr = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
		
		//fill the username field
		unamef.sendKeys(uname);
		sleep();
		
		//fill the password field
		pwordf.sendKeys("passwords!");
		sleep();
		//click on login button
		loginbtn.click();
		sleep();
		
		//verify url is right
		String aftlgnurl = "https://the-internet.herokuapp.com/login";
		String acturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, aftlgnurl, "Actual url is not the same as url");
	
		//verify message is right
		WebElement errmsg =  driver.findElement(By.xpath("/html//div[@id='flash']"));
		String experru = "Your password is invalid!";
		String acterrmsgu = errmsg.getText();
		sleep();
		
		Assert.assertTrue(acterrmsgu.contains(experru), "Actual Error Message does not contain expected.\nActual: " + acterrmsgu +"\n");
		
		//close browser
		driver.quit();
	}
	
	//sleep function
	private void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e)
		{
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
