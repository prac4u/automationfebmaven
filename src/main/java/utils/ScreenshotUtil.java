package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static void takeScreenshot(WebDriver driver, String fileName) 
	{
		String path = System.getProperty("user.dir");
		
		String filePath = path +"\\screenshots\\"  + fileName;
		TakesScreenshot scr = (TakesScreenshot) driver;
		
		File srcFile = scr.getScreenshotAs(OutputType.FILE); // Taking screenshot content in a file
		
		File destFile = new File(filePath); //creating file inside our computer
		try {
		FileUtils.copyFile(srcFile, destFile);  //copying the screenshot content inside our computer file
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
