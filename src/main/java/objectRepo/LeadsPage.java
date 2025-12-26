package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	//declaration
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLeadBtn;

	@FindBy(name="lastname")
	private WebElement lastNameTf;

	@FindBy(name="company")
	private WebElement companytf;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//initialization
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}

	//utilization
	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}


	public WebElement getLastNameTf() {
		return lastNameTf;
	}


	public WebElement getCompanytf() {
		return companytf;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void enterTheFields(String lastName, String Org) {
		lastNameTf.sendKeys(lastName);
		companytf.sendKeys(Org);
		saveBtn.click();
	}
}
