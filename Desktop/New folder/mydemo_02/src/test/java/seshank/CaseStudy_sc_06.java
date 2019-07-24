package seshank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CaseStudy_sc_06 {
	 WebDriver driver;
  @Test 
  public void f() {
	
	  System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
//	  driver= Mydriver123.getdriver("ie");
	  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("lalitha");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();  
		driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		String s = driver.findElement(By.xpath("//span[text()='4500']")).getText();
		String N = "4500";
		Assert.assertEquals(s, N);
		System.out.println("payment page  is verified ");
		
		
		
		
		
		
	  
  }
}
