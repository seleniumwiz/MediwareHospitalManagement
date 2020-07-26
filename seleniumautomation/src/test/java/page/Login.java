package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import ExcelReading.ExcelRead;
import core.Data;
import core.commonLib;

public class Login extends commonLib {

	public String Opusercredentials;
	public String userinfo[];

	public void enterUserName() throws Exception {
		try {

			WebElement userName = driver.findElement(By.id(commonLib.getElementPropFile("TEXT_USERNAME_ID")));
			// Passing data direactly through HashMaps
			Opusercredentials = Data.getUserinfo().get("Outpatient");
			userinfo = Opusercredentials.split("_");
			userName.sendKeys(userinfo[0]);

			// Passing the data from excel through HashMapss
			String val = ExcelRead.getMapData("username");
			System.out.println("Value of the Key in Execl is :" + val);

		} catch (Exception e) {

			throw new Exception("Unable to Enter username", e);

		}

	}

	public void enterpassWord() throws Exception {
		try {

			WebElement Password = driver.findElement(By.id(commonLib.getElementPropFile("TEXT_PASSWORD_ID")));
			Password.sendKeys(userinfo[1]);

		} catch (Exception e) {
			throw new Exception("unable to enter password", e);
		}

	}

	public void opuserLogin() throws Exception {
		try {
			WebElement login = driver.findElement(By.id(commonLib.getElementPropFile("LOGIN_ID")));
			login.click();
			Thread.sleep(5000);

		} catch (Exception e) {
			throw new Exception("unable to login ", e);
		}

	}

	public void application_Selector() throws Exception {
		try {
			WebElement appselector = driver
					.findElement(By.xpath(commonLib.getElementPropFile("APPLICATION_SELECTION")));
			appselector.click();
			Thread.sleep(5000);

		} catch (Exception e) {
			
			throw new Exception("unable to click application selector ", e);
		}

	}

	public void appoinments() throws Exception {

		try {

			driver.switchTo().frame("CallingPageDiv");
			WebElement appoinment = driver.findElement(By.xpath(commonLib.getElementPropFile("APPOINMENT")));
			appoinment.click();
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			throw new Exception("unable to select ", e);
		}

	}

	public void timeSelect() throws Exception {

		try {

			Thread.sleep(3000);
			List<WebElement> allElement = driver.findElements(By.xpath(commonLib.getElementPropFile("TIME_SELECT")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", allElement.get(0));
			allElement.get(0).click();

		} catch (Exception e) {

			throw new Exception("Unable to select the time", e);
		}

	}

	public void newAppoinment() throws Exception {
		try {

			driver.switchTo().frame("AppointmentDiv");
			WebElement appoinment = driver.findElement(By.xpath(commonLib.getElementPropFile("PATIENT_ID")));
			appoinment.sendKeys(commonLib.getTestDataPropFile("PATIENT"));

		} catch (Exception e) {
			throw new Exception("Unable to enter patient id ", e);
		}

	}

	public void search_patient() throws Exception {

		try {

			WebElement search = driver.findElement(By.xpath(commonLib.getElementPropFile("SEARCH")));
			search.click();
		} catch (Exception e) {
			throw new Exception("unable to search", e);
		}

	}

	public void patientselect() throws Exception {

		try {
			Thread.sleep(3000);
			WebElement selectpatients = driver.findElement(By.id(commonLib.getElementPropFile("SELECT_PATIENT")));
			selectpatients.click();
			Thread.sleep(3000);

		} catch (Exception e) {
			throw new Exception("unable to select the patient", e);
		}

	}

	public void savepatientsappoinment() throws Exception {
		try {
			WebElement patient = driver.findElement(By.xpath(commonLib.getElementPropFile("SAVE_PATIENT")));
			patient.click();
			Thread.sleep(3000);

		} catch (Exception e) {
			throw new Exception("unable to save", e);

		}

	}

}
