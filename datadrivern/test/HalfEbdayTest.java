//package com.datadrivern.test;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import com.test.utility.TestUtil;
//
//
//public class HalfEbdayTest 
//{	
//	WebDriver driver;
//	@BeforeMethod
//	public void setUp()
//	{
//		ChromeOptions CO=new ChromeOptions();
//		CO.addArguments("--remote-allow-origins=*");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chetan Roman\\Desktop\\Chrome Jar\\chromedriver_win32\\chromedriver.exe");
//		driver=new ChromeDriver(CO);
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://signup.ebay.com");
//	}
//	@DataProvider(name="getTestData")
//	public Iterator<Object[]> getTestData()
//	{
//		ArrayList<Object[]> testData=TestUtil.getDataFromExcel();
//		System.out.println(testData);
//		return testData.iterator();
//	}
//	@Test(dataProvider ="getTestData" )
//	public void halfEbayRegPageTest(String firstName,String lastName,String emailId,String password)
//	{
//		driver.findElement(By.xpath("//*[@name=\"firstname\"]")).clear();
//		driver.findElement(By.xpath("//*[@name=\\\"firstname\\\"]")).sendKeys(firstName);			//firstName
//		
//		driver.findElement(By.xpath("//*[@name=\"lastname\"]")).clear();
//		driver.findElement(By.xpath("//*[@name=\\\"lastname\\\"]")).sendKeys(lastName);			//lastName
//		
//		driver.findElement(By.xpath("//*[@name=\"Email\"]")).clear();
//		driver.findElement(By.xpath("//*[@name=\\\"Email\\\"]")).sendKeys(emailId);			//Email
//		
//		driver.findElement(By.xpath("//*[@name=\"password\"]")).clear();
//		driver.findElement(By.xpath("//*[@name=\\\"password\\\"]")).sendKeys(password);			//Password
//		
//	}
//	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
//}
//
//
