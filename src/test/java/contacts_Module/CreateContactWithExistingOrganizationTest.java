package contacts_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.hpsf.HPSFException;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genenricLibraries.BaseClass;
import genenricLibraries.ExcelUtils;
import genenricLibraries.FileUtils;
import genenricLibraries.JavaUtils;
import genenricLibraries.WebDriverUtils;
import objectRepo.ContactsPage;
import objectRepo.CreateNewOrganizationPage;
import objectRepo.CreatingNewContactPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.OrganizationPage;

public class CreateContactWithExistingOrganizationTest extends BaseClass {
	//
	@Test
	public void CreateContactWithExistingOrganizationTest() throws Exception {
		String lastname=elib.readDataFromExcel("Contacts", 0, 1)+jlib.getRandom();
		String orgName=elib.readDataFromExcel("Organizations", 0, 1)+jlib.getRandom();

		HomePage hp=new HomePage(driver);
		hp.getOrganizationslink().click();
		//login togetOrganizationslink the application
		/*driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();
		//create organization
		driver.findElement(By.linkText("Organizations")).click();


		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();*/
		OrganizationPage op=new OrganizationPage(driver);
		op.organization();

		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.createOrganization(orgName);
		//organization name
		//	driver.findElement(By.xpath("//input[@type='text' and @name='accountname']")).sendKeys(orgName);
		//save button
		//	driver.findElement(By.xpath("//input[@class='crmbutton small save' and @name='button']")).click();

		Thread.sleep(3000);
		//create contact
		hp.getContactslink().click();

		ContactsPage c=new ContactsPage(driver);
		c.newcontactLink();

		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createContactWithMandatoryFieldExistingOrg(lastname, orgName,driver);

		/*driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//img[@title='Select']")).click();*/

		/*beffore changing to webutils
		 * Set<String> allwh = driver.getWindowHandles();

		for(String wh:allwh) {
			driver.switchTo().window(wh);

			String current = driver.getWindowHandle();
			if(!current.equals(parent)) {
				break;
			}
		}*/

		//using another method instead of for
		/*iterator<String> it=windows.iterator
		 * while(it.hasNext())
		 * {
		 * String wid=it.next();
		 * String currenttitle=driverswitchTo().window(wid).getTitle();
		 * if(currentTitle.contains("Accounts&action"))
		 * {
		 * break;
		 * }
		 * */



		/*wlib.switchToWindow(driver, "Accounts&action");
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		//driver.switchTo().window(parent);

		wlib.switchToWindow(driver, "Contacts&action");*/

		//driver.findElement(By.xpath("//input[@class='crmbutton small save' and @name='button']")).click();


		//signout
		//click on administrator button
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		WebElement actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String act = actual.getText();
		Assert.assertTrue(act.contains(lastname));
		/*if(actual.contains(lastname)) {
			System.out.println("contact created successfully");
		}
		else{
			System.out.println("contact is not created");
		}*/
		Thread.sleep(3000);

		//mousehover onnsignoutlink and click
		//	driver.findElement(By.linkText("Sign Out")).click();
		/*driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement signout = driver.findElement(By.linkText("Sign Out"));
		wlib.mouseHoverAndClickonEle(driver, signout);*/

	}
}
