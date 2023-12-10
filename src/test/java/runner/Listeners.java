package runner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.Utils;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Application Launched");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On test success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Utils takeScreenshot = new Utils();
		try {
			takeScreenshot.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On test failed within success percentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Timed out");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On start");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Browser closed");
	}
	
	

}
