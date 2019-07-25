package TC_01;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  
		
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		 
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("lalitha");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
		String S = driver.getTitle();
		String N = "Home";
		Assert.assertEquals(S, N);
		System.out.println("Succesful");
		
		driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
		
		driver.close();
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
