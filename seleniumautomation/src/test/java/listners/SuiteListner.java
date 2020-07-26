package listners;

import java.io.IOException;

import org.apache.commons.mail.EmailException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import core.SendEmail;
import testPackage.LoginTest;
import ExcelReading.ExcelRead;

public class SuiteListner extends LoginTest implements ISuiteListener {
	public static ExtentHtmlReporter htmlReporter;

	/*
	 * author:Manu Mohan
	 * 
	 * Extent Report Generation integrated with IsuiteListner class.
	 */

	public void onStart(ISuite suite) {
		
		System.out.println("Suite executed onStart" + suite.getName());

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/mediwareTestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report of Mediware Automation");
		htmlReporter.config().setReportName(" ExtentReport");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	/*
	 * Extent Report will end here and Email will sent.
	 */
	public void onFinish(ISuite suite) {
		System.out.println("Suite executed onFinish" + suite.getName());
		extent.flush();
		try {

			// Sending the ExtentReport
			SendEmail.emailsend();
		} catch (EmailException e) {

			e.printStackTrace();
		}
	}

}
