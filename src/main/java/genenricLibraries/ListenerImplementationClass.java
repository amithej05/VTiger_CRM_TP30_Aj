package genenricLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	/**
	 * ThreadLocal is used to support PARALLEL execution.
	 * Each thread (test) gets its own ExtentTest instance.
	 */
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	/**
	 * This method is executed BEFORE every @Test method
	 */
	@Override
	public void onTestStart(ITestResult result) {

		// Fetching test method name
		String methodName = result.getMethod().getMethodName();

		// Creating test entry in Extent Report
		test = report.createTest(methodName);

		// Setting ExtentTest object to ThreadLocal
		extentTest.set(test);

		// Logging test start information
		extentTest.get().log(Status.INFO, methodName+" execution starts");
	}

	/**
	 * This method is executed when a test case PASSES
	 */
	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();

		// Logging PASS status in report
		extentTest.get().log(Status.PASS,"<b>"+ methodName+" passed</b>");
	}

	/**
	 * This method is executed when a test case FAILS
	 */
	@Override
	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();	

		// Creating unique screenshot file name using date
		String fileName = methodName + new JavaUtils().sysdate();

		try {
			// Capturing screenshot using Selenium
			TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;

			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(".\\screenshot\\" + fileName + ".png");

			// Saving screenshot to local folder
			FileUtils.copyFile(src, dest);

			// Getting absolute path of screenshot
			String path = dest.getAbsolutePath();

			// Attaching screenshot to Extent Report
			extentTest.get().addScreenCaptureFromPath(path);

			// Logging exception details
			extentTest.get().log(Status.FAIL, result.getThrowable());

			// Logging failure message
			extentTest.get().log(Status.FAIL,"<i>"+ methodName+"failed</i>");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is executed when a test case is SKIPPED
	 */
	@Override
	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();

		// Logging SKIP status
		extentTest.get().log(Status.SKIP, methodName+" skipped");
		extentTest.get().log(Status.WARNING, methodName+" warning");
		
	}

	/**
	 * This method is executed BEFORE test execution starts
	 * (Before @BeforeSuite)
	 */
	@Override
	public void onStart(ITestContext context) {

		// Creating Extent Spark Reporter with dynamic file name
		ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtentReport\\report" + new JavaUtils().sysdate() + ".html");

		// Report UI configurations
		html.config().setDocumentTitle("TP-30");
		html.config().setTheme(Theme.STANDARD);
		html.config().setReportName("Vtiger");

		// Initializing ExtentReports
		report = new ExtentReports();

		// Attaching reporter to ExtentReports
		report.attachReporter(html);

		// Adding system/environment details
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("base_platform", "windows");
		report.setSystemInfo("base_url", "http://localhost:8888");
		report.setSystemInfo("reportername", "amith");
	}

	/**
	 * This method is executed AFTER all tests are finished
	 */
	@Override
	public void onFinish(ITestContext context) {

		// Flush writes all logs into the report
		report.flush();
	}
}
