package utils;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Feb Class\\chrome113\\chromedriver.exe");
		//open browser
		 WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		
		String hindiString = new String("हिन्दी");
		String hindi = "hi_IN";
		Locale locale = new Locale(hindi);
		System.out.println(locale.toString());
		byte[] array1 = hindiString.getBytes();
				
		byte[] array2 = driver.findElement(By.xpath("//div[contains(@id,'languages')]//a[1]")).getText().getBytes("UTF-8");
	
	 System.out.println(array1);
	 System.out.println(array2);
	 
	 System.out.println(array1.equals(array2));
	 
	 
	}
}
