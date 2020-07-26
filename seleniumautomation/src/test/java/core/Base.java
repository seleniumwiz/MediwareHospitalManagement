package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import static org.testng.Assert.assertEquals;


/*
 * Author:Manu Mohan
 * Here the Chromedriver is initialized and the URL is given. An assertion is
 * given for checking the title of the login page .
 */
public class Base {
	public static WebDriver driver;
	static String title;

	@BeforeTest

	public static void BaseClass() throws Exception {

		System.setProperty("WebDriver.chrome.driver", "E:\\Workspace\\STS\\seleniumautomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mediwarecloud.com/MediwareQC/login.aspx");
		title = "Mediware Hospital Information System";
		assertEquals(driver.getTitle(), title);

	}

}
