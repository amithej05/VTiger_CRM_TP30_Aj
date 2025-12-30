package contacts_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
//done
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import genenricLibraries.BaseClass;
import genenricLibraries.ExcelUtils;
import genenricLibraries.FileUtils;
import genenricLibraries.JavaUtils;
import genenricLibraries.WebDriverUtils;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
//done
public class CreateContactsWithMandatorytextFieldsTest {
	
	@Test(groups="smoke")
	public void CreateContactsWithMandatorytextFieldsTest() throws Exception {
		
		String last_Name = elib.readDataFromExcel("Contacts", 0, 1)+jlib.getRandom();

		
		//login to the application
	/*	driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();*/
		
	
		
		HomePage hp=new HomePage(driver);
		hp.getContactslink().click();
		
	//	driver.findElement(By.linkText("Contacts")).click();
		
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.newcontactLink();
		
		
		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
		cnp.createContactWithMandatoryField(last_Name);
	//	driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(last_Name);
	//	driver.findElement(By.xpath("//input[@class='crmbutton small save' and @name='button']")).click();
		
		 WebElement actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String act = actual.getText();
		Assert.assertTrue(act.contains(last_Name));
		/*if(actual.contains(last_Name)) {
			System.out.println("contact created successful");
		}
		else{
			System.out.println("contact is not created");
		}
		//Sign out
		/*driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement signout = driver.findElement(By.linkText("Sign Out"));
		wlib.mouseHoverAndClickonEle(driver, signout);*/
		Thread.sleep(2000);
		Assert.fail();

	}

}
