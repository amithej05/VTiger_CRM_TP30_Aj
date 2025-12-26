package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genenricLibraries.WebDriverUtils;

public class DocumentPage extends WebDriverUtils{

	

	//declaration
	@FindBy(xpath="//img[@title='Create Document...']")
	private WebElement newDocumentBtn;
	
	@FindBy(xpath="//input[@name='notes_title']")
	private WebElement titleTf;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savveBtn;
	
	@FindBy(name="Edit")
	private WebElement editBtn;
	
	@FindBy(xpath="//input[@name='notes_title']")
	private WebElement etitleTf;

	public WebElement getEtitleTf() {
		return etitleTf;
	}
	
	@FindBy(name="Delete")
	private WebElement delBtn;

	//initialization
	public DocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewDocumentBtn() {
		return newDocumentBtn;
	}

	public WebElement getTitleTf() {
		return titleTf;
	}

	public WebElement getSavveBtn() {
		return savveBtn;
	}
	
	
	public WebElement getDelBtn() {
		return delBtn;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public void editDoc(String editTitle) {
		titleTf.sendKeys(editTitle);
		savveBtn.click();
		
	}
	
	public void saveDoc(String exptitle) {
		etitleTf.sendKeys(exptitle);
		savveBtn.click();
		
	}
	
	public void deleteDoc(WebDriver driver) {
		delBtn.click();
		acceptAlertPopup(driver);
	}
	
	
}
