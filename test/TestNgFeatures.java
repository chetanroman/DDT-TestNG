package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures 
{

	@Test
	public void loginTest()
	{
		System.out.println("Login Test");
	}
	@Test(dependsOnMethods = "loginTest")
	public void HomePageTest()
	{
		System.out.println("Home page Test dependent on login Test");
	}
	@Test(invocationCount = 5)
	public void SearchPageTest()
	{
		System.out.println("Search Page Test");
	}
	@Test(expectedExceptions = Exception.class)
	public void TestException()
	{
		int i=9;
		i=i/0;
		System.out.println(i);
	}
}
