package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTestValidating 
{
WebDriver driver;
	
	@BeforeMethod
	public void setUp() 
	{
		ChromeOptions CO=new ChromeOptions();
		CO.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chetan Roman\\Desktop\\Chrome Jar\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver(CO);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	@Test
	public void googleTitleTest()
	{
		String title= driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Google","Title not matching");
	}
	
	@Test
	public void googleLogoTest()
	{
		boolean b=driver.findElement(By.xpath(".//*[@class='lnXdpd']")).isDisplayed();
		Assert.assertTrue(b);
		//Assert.assertEquals(b, true);//We can use both types to validate.
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
