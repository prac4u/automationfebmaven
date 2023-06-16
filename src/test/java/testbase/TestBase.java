package testbase;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import driverfactory.DriverFactory;
import utils.PropConfig;
import utils.ScreenshotUtil;
public class TestBase {
	 protected  WebDriver driver;
	 protected static Properties prop;
	 DriverFactory df;
	 
	 static Logger log = Logger.getLogger(TestBase.class.getName());
	 
	 @BeforeTest
	 public void beforeTest()
	 {
		 log.info("Inside before Test method");

		 System.out.println("Initializing Properties file");
		 prop = PropConfig.init_prop("SIT"); 
		 log.info("Properties file is initilized");
	 }
	
//	@Parameters(value = {"browser"})
	@BeforeMethod
	//public void beforeMethod(String browser)
	public void beforeMethod()
	{
		System.out.println("Opening browser");
		//System.setProperty("webdriver.chrome.driver", "C:\\Feb Class\\chrome113\\chromedriver.exe");
		//open browser
		String browser = prop.get("browser").toString();
//		if(browser.equals("chrome"))
//		{
//		WebDriverManager.chromedriver().setup();
//		 driver = new ChromeDriver();
//		}
//		else if(browser.equals("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//		else if(browser.equals("ff"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
		df = new DriverFactory();
		 driver = df.init_driver();
		 
		driver.manage().window().maximize();
		//launch login url
		System.out.println("opening URL");
		String url = prop.get("url").toString();
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[contains(@class,'orangehrm-login-title')]")));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		String testcaseName = result.getMethod().getMethodName();
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			log.info("Test case failed " + testcaseName);
			String fileName =testcaseName + ".png";
			ScreenshotUtil.takeScreenshot(driver, fileName);
		}
		
		driver.quit();
	}

}
