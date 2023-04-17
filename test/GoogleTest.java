package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest 
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
	
	@Test(priority = 2,groups="Title")
	public void googleTitleTest()
	{
		String title= driver.getTitle();
		System.out.println(title);
	}
	@Test(priority = 1,groups="Logo")
	public void googleLogoTest()
	{
		boolean b=driver.findElement(By.xpath(".//*[@class='lnXdpd']")).isDisplayed();
	}
	@Test(priority = 3,groups="Link Text")
	public void mailLinkTest()
	{
		boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
	}
	@Test(priority = 4,groups="Title")
	public void testTitlegroup()
	{
		System.out.println("Titile group Test");
	}
	@Test(priority = 5,groups="Logo")
	public void testLogotgroup()
	{
		System.out.println("Logo group Test");
	}
	@Test(priority = 6,groups="Link Text")
	public void testLinkTextgroup()
	{
		System.out.println("Link Text group Test");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
