package driverfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	WebDriver driver;
	
	public WebDriver init_driver()
	{
		
		WebDriverManager.chromedriver().setup();
		tldriver.set(new ChromeDriver());
		//driver = new ChromeDriver();
		tldriver.get().manage().window().maximize();
		tldriver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return tldriver.get();
		
	}
	
	
	
	public WebDriver getDriver()
	{
		
		return tldriver.get();
	}

}
