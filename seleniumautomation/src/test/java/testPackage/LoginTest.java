package testPackage;

import org.apache.commons.mail.EmailException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.commonLib;
import page.Login;

@Listeners({ listners.TestListner.class, listners.SuiteListner.class })

public class LoginTest extends commonLib {
	private Login obj;
	public static ExtentTest test;
	public static ExtentReports extent;

	@BeforeClass
	public void initObjects() {

		obj = new Login();

	}

	@Test(priority = 1)
	public void Mediwarelogin() throws Exception {

		try {

			obj.enterUserName();
			obj.enterpassWord();
			obj.opuserLogin();

			test = extent.createTest("Test Case 1", "passed");
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.err.println("Test : Failed, " + " Message :" + e.getMessage() + " , Cause : " + e.getCause());

			test = extent.createTest("Test Case 1", "failed");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void MediwareAppoinment() throws Exception {

		try {
			obj.application_Selector();
			obj.appoinments();
			obj.timeSelect();
			test = extent.createTest("Test Case 2", "passed");
			Assert.assertTrue(true);
		} catch (Exception e) {
			System.err.println("Test : Failed, " + " Message :" + e.getMessage() + " , Cause : " + e.getCause());
			test = extent.createTest("Test Case 2", "failed");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 3)
	public void PatietSearch() throws Exception {

		try {
			obj.newAppoinment();
			obj.search_patient();
			obj.patientselect();
			obj.savepatientsappoinment();

			test = extent.createTest("Test Case 3", "PASSED");
			Assert.assertTrue(true);

		} catch (Exception e) {

			System.err.println("Test : Failed, " + " Message :" + e.getMessage() + " , Cause : " + e.getCause());
			test = extent.createTest("Test Case 3", "failed");
			Assert.assertTrue(false);
		}

	}

	@AfterMethod

	static void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

}
