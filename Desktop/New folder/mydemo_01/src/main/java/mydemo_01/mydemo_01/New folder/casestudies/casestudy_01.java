package casestudies;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class casestudy_01 {
	WebDriver driver;
     ExtentHtmlReporter htmlReporter;
     ExtentReports extent;
	ExtentTest test;
	@Test (priority=2)
	  public void openbrowser()
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  driver.manage().window().maximize();
		  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("lalitha");
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
		 driver.findElement(By.xpath("//input[@name='Login']")).click();
	}
		 
		 @Test	(priority=1)	
		    public void launchGoogle() {				
		        driver.get("http://www.google.co.in");						
		    }	
		 @AfterMethod 
		 public void getResult(ITestResult result) throws IOException {
		 	 if(result.getStatus() == ITestResult.FAILURE) {
		 			 test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED", ExtentColor.RED));
		 			 
		 			 TakesScreenshot snapshot = (TakesScreenshot)driver;
		 			 File src = snapshot.getScreenshotAs(OutputType.FILE);
		 			 String path = System.getProperty("user.dir")+ "/test-output/screens/"+result.getName()+".png";
		 			 FileUtils.copyFile(src ,new File(path));
		 			 test.addScreenCaptureFromPath(path,result.getName());
		 			 test.fail(result.getThrowable());
		 		 }
		 		 else if(result.getStatus()== ITestResult.SUCCESS) {
		 			 test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "PASSED", ExtentColor.GREEN));
		 	 }
		 		 else {
		 			 test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"SKIPPED", ExtentColor.ORANGE));
		 			 test.skip(result.getThrowable());
		 			 }
		 	 @BeforeTest 
		 	  public void startReport() {
		 		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
		 		  extent = new ExtentReports();
		 		  extent.attachReporter(htmlReporter);
		 		  htmlReporter.config().setDocumentTitle("Extent Report Demo");
		 		  htmlReporter.config().setReportName("Test Report");
		 		  htmlReporter.config().setTheme(Theme.STANDARD);
		 		  htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a '('zzz')'");
		 		  
		 	  }
		 	  @AfterTest 
		 	  public void tearDown() {
		 		  extent.flush();
		 	  }
		 	  }

		
}
