package com.parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest 
{
	//https://login.yahoo.com/
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() 
	{
		ChromeOptions CO=new ChromeOptions();
		CO.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chetan Roman\\Desktop\\Chrome Jar\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver(CO);
		driver.manage().window().maximize();
	}
	
	@Test
	@Parameters({"url","emailId"})
	public void yahooLoginTest(String url,String emailId)
	{
		driver.get(url);
		driver.findElement(By.xpath("//*[@id='login-username']")).clear();
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(emailId);
		driver.findElement(By.xpath("//*[@id='login-signin']")).click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
