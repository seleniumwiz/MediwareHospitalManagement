package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestListener;

import com.aventstack.extentreports.Status;

public class TestListner implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		System.out.println("Success of test cases and its details are : " + result.getName());
	}

	
	public void onTestSuccess(ITestResult result) {

		System.out.println("Passed Test cases and its details are " + result.getName());
	}


	public void onTestFailure(ITestResult result) {

		System.out.println("Failure of test cases and its details are : " + result.getName());
	}

	
	public void onTestSkipped(ITestResult result) {

		System.out.println("Skip of test cases and its details are : " + result.getName());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("Failure of test cases and its details are : " + result.getName());
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
