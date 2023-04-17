package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics 
{

	@BeforeSuite
	public void setUP()
	{
		System.out.println("@BeforeSuite----------Set up system property for chrome");
	}
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("@BeforeTest-----------Launch the browser");
	}
	@BeforeClass
	public void login()
	{
		System.out.println("@BeforeClass----------Login to application");
	}
	@BeforeMethod
	public void enterURL()
	{
		System.out.println("@BeforeMethod----------Enter URL");
	}
	
	@Test
	public void googleTitleTest() 
	{
		System.out.println("@Test----------Google Title Test");
	}
	@Test
	public void searchTest()
	{
		System.out.println("@Test----------search test");
	}
	@Test
	public void googleLogoTest()
	{
		System.out.println("@Test----------Google logo test");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("@AfterMethod----------Logout from app");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("@AfterClass----------Close Browser");
	}
	
	@AfterTest
	public void deleteAllCoockies() 
	{
		System.out.println("@AfterTest----------Delete all coockies");
	}
	
	
	
	
	
	
	
	
	
	
	
}
