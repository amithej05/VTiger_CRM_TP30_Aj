package genenricLibraries;

import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class SampleBase_Class {

	public FileUtils flib=new FileUtils();
	public ExcelUtils elib=new ExcelUtils();
	public JavaUtils jlib=new JavaUtils();
	public DaatabaseUtils dlib=new DaatabaseUtils();
	public WebDriverUtils wlib=new WebDriverUtils();


	@BeforeSuite
	public void connectToDB() throws SQLException {
		System.out.println("connect to DB---@BeforeSuite");
	}

	@BeforeClass
	public void launchBrowser() throws Exception {
		System.out.println("openbrowser---@BeforeClass");

	}


	@BeforeMethod
	public void loginToApp() throws Exception {
		System.out.println("login--@BeforeMethod");
	}

	@AfterMethod(alwaysRun = true)
	public void logoutOfApp() throws InterruptedException {

		System.out.println("logout--@AfterMethod");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("close browser--@AfterClass");
	}

	@AfterSuite

	public void disconnectToDB() throws SQLException {
		System.out.println("disconnectDB--@AfterSuite");
	}
}
