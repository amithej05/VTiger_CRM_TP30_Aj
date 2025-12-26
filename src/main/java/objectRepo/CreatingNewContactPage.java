package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genenricLibraries.WebDriverUtils;

public class CreatingNewContactPage extends WebDriverUtils{
	
	//declaration
	@FindBy(name="lastname")
	private WebElement lastnameTf ;
	
	@FindBy(xpath="//input[@class='crmbutton small save' and @name='button']")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement searchTf;

	@FindBy(name="search")
	private WebElement searchBtn1;

	@FindBy(xpath="//img[@title='Select']")
	private WebElement creOrgbtn;
	
	public WebElement getSearchTf() {
		return searchTf;
	}

	public WebElement getSearchBtn1() {
		return searchBtn1;
	}

	public WebElement getCreOrgbtn() {
		return creOrgbtn;
	}

	//initialization
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	//utilization
	public WebElement getLastnameTf() {
		return lastnameTf;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContactWithMandatoryField(String lastName) { 
	
		lastnameTf.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContactWithMandatoryFieldExistingOrg(String lastName,String orgName,WebDriver driver ) throws InterruptedException { 
		
		lastnameTf.sendKeys(lastName);
		Thread.sleep(2000);
		creOrgbtn.click();
		Thread.sleep(2000);
		switchToWindow(driver, "Accounts&action");
		Thread.sleep(2000);
		searchTf.sendKeys(orgName);
		Thread.sleep(2000);
		searchBtn1.click();
		driver.findElement(By.linkText(orgName)).click();
		Thread.sleep(2000);
		switchToWindow(driver, "Contacts&action");
		Thread.sleep(2000);
		saveBtn.click();
	}
}
