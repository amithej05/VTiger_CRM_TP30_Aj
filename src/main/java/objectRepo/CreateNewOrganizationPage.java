package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genenricLibraries.ExcelUtils;
import genenricLibraries.WebDriverUtils;

public class CreateNewOrganizationPage extends WebDriverUtils {
		//declaration
		@FindBy(xpath="//input[@type='text' and @name='accountname']")
		private WebElement OrganizationNameBtn;
		
		@FindBy(xpath="//input[@class='crmbutton small save' and @name='button']")
		private WebElement saveBtn;
		
		@FindBy(name="industry")
		private WebElement industryDpdown;
		
		@FindBy(name="accounttype")
		private WebElement typeDpdown;
		
		//initialization
		public CreateNewOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public WebElement getOrganizationNameBtn() {
			return OrganizationNameBtn;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}

		public WebElement getIndustryDpdown() {
			return industryDpdown;
		}

		public WebElement getTypeDpdown() {
			return typeDpdown;
		}

		/*public WebElement getSearchTf() {
			return searchTf;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}*/
		
		public void createOrganization(String orgName) {
		
	
			OrganizationNameBtn.sendKeys(orgName);
			saveBtn.click();
		}
		
		public void createOrganizationwithTxtField(String orgName,String industry, String type) {
			
			OrganizationNameBtn.sendKeys(orgName);
			dropdownUsingContainsVisibleText(industryDpdown, industry);
			dropdownUsingContainsVisibleText(typeDpdown, type);
			saveBtn.click();
		}
		
		
}
