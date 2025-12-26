package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genenricLibraries.WebDriverUtils;

public class OrganizationPage extends WebDriverUtils {

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrganizationBtn;

	@FindBy(name="search_text")
	private WebElement searchTf;

	@FindBy(name="search")
	private WebElement searchBtn;

	//initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}

	//utilization
	public WebElement getCreateOrganizationBtn() {
		return CreateOrganizationBtn;
	}

	public WebElement getSearchTf() {
		return searchTf;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void organization() {
		CreateOrganizationBtn.click();
	}

	public void organizationPageSwhWid(WebDriver driver,String orgName) throws InterruptedException {

		switchToWindow(driver, "Accounts&action");
		searchTf.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.linkText(orgName)).click();	
		switchToWindow(driver, "Contacts&action");



	}
}
