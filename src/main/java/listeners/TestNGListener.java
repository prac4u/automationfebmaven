package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.PropConfig;


public class TestNGListener implements ITestListener{

	static Logger log = Logger.getLogger(TestNGListener.class.getName());
	@Override
	public void onTestStart(ITestResult result) {
		log.info("---------------------------------------------------------------------");
		log.info("Execution started for Testcase : " + result.getMethod().getMethodName());
		log.info("---------------------------------------------------------------------");
		System.out.println("OnTestStart : " + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info(result.getMethod().getMethodName()  + " : PASS");
		System.out.println("onTestSuccess : " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info(result.getMethod().getMethodName()  + " : FAIL");
		System.out.println("onTestFailure : " + result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info(result.getMethod().getMethodName()  + " : SKIP");
		System.out.println("onTestSkipped : " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		log.info("---------------------------------------------------------------------");
		log.info("Execution started");
		log.info("---------------------------------------------------------------------");
		System.out.println("onStart " + context.getStartDate());
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("---------------------------------------------------------------------");
		log.info("Execution Finished");
		log.info("---------------------------------------------------------------------");
		System.out.println("onFinish " + context.getEndDate());
	}
	

}
