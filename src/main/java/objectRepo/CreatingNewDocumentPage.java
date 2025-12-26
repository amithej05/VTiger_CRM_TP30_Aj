package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewDocumentPage {
	
	//declaration
		@FindBy(linkText="Documents")
		private WebElement lastnameTf ;
		
		@FindBy(name="notes_title")
		private WebElement titleTf;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		public WebElement getLastnameTf() {
			return lastnameTf;
		}

		public WebElement getTitleTf() {
			return titleTf;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//initialization
		public CreatingNewDocumentPage(WebDriver driver) {
			PageFactory.initElements( driver, this);
		}

}
