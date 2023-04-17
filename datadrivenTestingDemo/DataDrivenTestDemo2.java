package com.datadrivenTestingDemo;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestDemo2
{
	WebDriver driver;
	int i=1;
	@BeforeMethod
	public void setUp()
	{
		ChromeOptions CO=new ChromeOptions();
		CO.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chetan Roman\\Desktop\\Chrome Jar\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver(CO);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	@Test(dataProvider="LoginData")
	public void loginTest(String email,String password,String expected_Result) throws InterruptedException 
, IOException
	{
		//System.out.println(email+password);
		
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);			//Email
		
		driver.findElement(By.xpath("//input[@name='pass']")).clear();
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);			//Password
		
		driver.findElement(By.xpath("//button[@name='login']")).click();
		//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		Thread.sleep(10000);
		String expected_url="https://www.facebook.com/?sk=welcome";
		String actual_url=driver.getCurrentUrl();
		//Assert.assertEquals(actual_url, expected_url);
		String path="C:\\Users\\Chetan Roman\\Desktop\\Excel file\\Registration_data.xlsx";
		XLUtility setdatatoexcel=new XLUtility(path);
		System.out.println(actual_url);
		
		
			
		if(expected_Result.equals("Pass"))
		{
			if(expected_url.equals(actual_url))
			{
				Assert.assertTrue(true);
				setdatatoexcel.setCellData("Sheet1",i,3,"Pass");
				i++;
			}
			else
			{
				Assert.assertTrue(false);
				setdatatoexcel.setCellData("Sheet1",i,3,"Fail123");
				i++;
			}
		}
		else if(expected_Result.equals("Fail"))
		{
			if(expected_url.equals(actual_url))
			{
				Assert.assertTrue(false);
				setdatatoexcel.setCellData("Sheet1",i,3,"Pass");
				i++;
			}
			else
			{
				Assert.assertTrue(true);
				setdatatoexcel.setCellData("Sheet1",i,3,"Fail");
				i++;
			}
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path="C:\\Users\\Chetan Roman\\Desktop\\Excel file\\Registration_data.xlsx";
		XLUtility xlu=new XLUtility(path);
		int totalRows=xlu.getRowCount("Sheet1");
		int totalColoumns=xlu.getCellCount("Sheet1", 1);
		String loginData[][]=new String[totalRows][totalColoumns];
		
		for(int i=1;i<=totalRows;i++)
		{
			for(int j=0;j<totalColoumns;j++)
			{
				loginData[i-1][j]=xlu.getCellData("Sheet1", i, j);
			}
		}
		//System.out.println(loginData);
		return loginData;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}