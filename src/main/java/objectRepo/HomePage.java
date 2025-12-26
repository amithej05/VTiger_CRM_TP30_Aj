package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genenricLibraries.WebDriverUtils;

public class HomePage extends WebDriverUtils {
	//initialization
	@FindBy(linkText="Leads")
	private WebElement leadslink;

	@FindBy(linkText="Organizations")
	private WebElement organizationslink;

	@FindBy(linkText="Contacts")
	private WebElement Contactslink;
	
	@FindBy(linkText="Documents")
	private WebElement Documentsllink;

	@FindBy(linkText="Opportunities")
	private WebElement Opportunitieslink;

	@FindBy(linkText="Products")
	private WebElement Productslink;

	@FindBy(linkText="Trouble Tickets")
	private WebElement TroubleTicketBtn;

	@FindBy(id="qccombo")
	private WebElement quickCreateDpDown;

	@FindBy(xpath="//option[@value='ServiceContracts']")
	private WebElement newServiceContract;

	@FindBy(id="subject")
	private WebElement subjectTf;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;



	@FindBy(xpath="//td[@class='small']/img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement settingsBtn;

	@FindBy(linkText="CRM Settings")
	private WebElement CRMSettingBtn;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorBtn;

	@FindBy(xpath="//a[@href='index.php?module=Users&action=Logout']")
	private WebElement SignoutBtn;

	@FindBy(linkText="More")
	private WebElement moreLink ;

	@FindBy(name="Service Contracts")
	private WebElement serviceCOntractsLink ;
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}



	//utilization
	public WebElement getLeadslink() {
		return leadslink;
	}
	

	public WebElement getDocumentsllink() {
		return Documentsllink;
	}



	public WebElement getOrganizationslink() {
		return organizationslink;
	}

	public WebElement getContactslink() {
		return Contactslink;
	}

	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}


	public WebElement getNewServiceContract() {
		return newServiceContract;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getServiceCOntractsLink() {
		return serviceCOntractsLink;
	}

	public WebElement getProductslink() {
		return Productslink;
	}

	public WebElement getTroubleTicketBtn() {
		return TroubleTicketBtn;
	}

	public WebElement getQuickCreateDpDown() {
		return quickCreateDpDown;
	}

	public WebElement getSubjectTf() {
		return subjectTf;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSettingsBtn() {
		return settingsBtn;
	}

	public WebElement getCRMSettingBtn() {
		return CRMSettingBtn;
	}

	public WebElement getAdministratorBtn() {
		return administratorBtn;
	}

	public WebElement getSignoutBtn() {
		return SignoutBtn;
	}


	//business logic
	public void signout(WebDriver driver,WebDriverUtils wlib) throws InterruptedException {
		administratorBtn.click();
		waitUntilEleToBeVisible(driver, 10, SignoutBtn);
		
		//wlib.mouseHoverAndClickonEle(driver, SignoutBtn);
		clickOnElementusingJSE(driver, SignoutBtn);
	}
	
	public void serviceCOntractDpdown(String service,String subject) throws InterruptedException {
		dropdownUsingContainsVisibleText(quickCreateDpDown, service);
		Thread.sleep(2000);
		subjectTf.sendKeys(subject);
		Thread.sleep(2000);
		saveBtn.click();
	}
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement delBtn ;
	
	public WebElement getDelBtn() {
		return delBtn;
	}
	public void deleteService(WebDriver driver) {
		delBtn.click();
		acceptAlertPopup(driver);
	}
	public boolean isUserLoggedIn(WebDriver driver) {
	    return administratorBtn.isDisplayed();
	}
	
	public void clickOnSettings(WebDriver driver) {
		clickOnEle(driver, settingsBtn);
		clickOnEle(driver, CRMSettingBtn);
	}

}
