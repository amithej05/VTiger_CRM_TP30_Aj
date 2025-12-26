package genenricLibraries;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleListenerImp implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart Isuite");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish Isuite");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart of listener");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess of listener");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure of listener");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped of listener");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage of listener");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout of listener");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart of itestListener");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish of itestListener");
	}

}
