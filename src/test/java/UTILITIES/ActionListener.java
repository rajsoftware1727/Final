package UTILITIES;

import java.awt.Desktop;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig.ExtentSparkReporterConfigBuilder;

public class ActionListener implements ITestListener{
	
	String reportname;
	ExtentReports extentReport;
	ExtentSparkReporter sparkReporter;
	ExtentTest extenttest;
	/*
	 * which tell some block of code execute before and after success and failure
	 */
	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("execution started");
 		String timestamp=new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Date());
		  reportname="testReport-"+timestamp+".html";
		  extentReport=new ExtentReports();
		  sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//test-output//"+reportname);
		extentReport.attachReporter(sparkReporter);
		
   
		 
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("test on started");
		
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("test  success");
		
		  extenttest=extentReport.createTest(result.getName());
		  extenttest.pass(result.getName());

		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("test  failed");

		extenttest=extentReport.createTest(result.getName());
		  extenttest.fail(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("test on skipped");

		 
	}

	 

	 

	@Override
	public void onFinish(ITestContext context) {
		 
		System.out.println("execution finished");
		extentReport.flush();
		try {
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"//test-output//"+reportname).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	 
	

}
