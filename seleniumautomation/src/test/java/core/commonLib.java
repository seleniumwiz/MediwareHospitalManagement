package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/*
 * Author: Manu Mohan
 *For accessing the data stored in the property files in config Folder
 */


public class commonLib extends Base {
	
	
	public static String getElementPropFile(String strQuery) {
		Properties prop = new Properties();
		File file = new File("E:\\Workspace\\STS\\seleniumautomation\\config\\element.properties");
		String strData = "";
		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fileInput);
			strData = prop.getProperty(strQuery);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return strData;
	}

	public static String getTestDataPropFile(String strQuery) {
		Properties prop = new Properties();
		File file = new File("E:\\Workspace\\STS\\seleniumautomation\\config\\testdata.properties");
		String strData = "";
		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fileInput);
			strData = prop.getProperty(strQuery);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return strData;
	}

	public static String getEmailPropFile(String strQuery) {
		Properties prop = new Properties();
		File file = new File("E:\\Workspace\\STS\\seleniumautomation\\config\\testdata.properties");
		String strData = "";
		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fileInput);
			strData = prop.getProperty(strQuery);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return strData;
	}

}
