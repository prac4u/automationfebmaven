package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utils.Constants;
import utils.ExcelReader;

public class HomePageTest extends TestBase{
	
	static Logger log = Logger.getLogger(HomePageTest.class.getName());
	//Assert vs SoftAssert (Both are classes)
	//if any assertion in "Assert" class is failed, next code will not be executed - so we "Assert" as Hard Assert
	//Soft Assert, checks all the assertion at the end, so all the code will be excuted even if any assertion is failing
	//all the methods in Assert class are static in nature - so we need not to create the object
	//Methods in SoftAssert class are not static so we have to create object of SoftAssert class
	
	@Test
	public void verify_username() throws InterruptedException
	{
		LoginPage page = new LoginPage(driver);
		//To read the credentials from Excel file
//		ExcelReader cred = new ExcelReader("credentials.xlsx");
//		Map<String,String> credMap = cred.getDataInMap(1);
		//HomePage hp = page.doLogin(credMap.get("Username"), credMap.get("Password"));
		
		//To Read the credentials from properties file
		HomePage hp = page.doLogin(prop.get("username").toString(), prop.get("password").toString());
		String actualHeader = hp.getHeader();
		System.out.println();
		log.info("Home Page Header Assertion" );
		log.info("Actual Header : " +  actualHeader );
		log.info("Expected Header : " +  Constants.HOME_PAGE_HEADER );
		Assert.assertEquals(actualHeader, Constants.HOME_PAGE_HEADER);
		String username = hp.getUsername();
		Thread.sleep(5000);
		
		log.info("Home Page username Assertion" );
		log.info("Actual Header : " +  username );
		log.info("Expected Header : " +   Constants.USERNAME );
		Assert.assertEquals(username, Constants.USERNAME);
		
	}
	
	
	@Test
	public void Verify_Links()
	{
		LoginPage page = new LoginPage(driver);
		HomePage hp = page.doLogin("Admin", "admin123");
		String actualHeader = hp.getHeader();
		Assert.assertEquals(actualHeader, Constants.HOME_PAGE_HEADER);
		
		List<String> actualList = hp.getMenuList();
		
		SoftAssert softAssert = new SoftAssert();
		for(int i=0; i<actualList.size();i++)
		{
			String actual = actualList.get(i);
			String expected = Constants.HOME_PAGE_MENU_LIST.get(i);
			System.out.println("Expected : " + i + " " + expected );
			System.out.println("Actual : " + i + " " + actual );
			softAssert.assertEquals(actual, expected);
		}
		
	softAssert.assertAll();	
		
	}
	
	
}
