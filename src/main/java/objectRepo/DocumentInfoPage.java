package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInfoPage {

	@FindBy(name="Edit")
	private WebElement EditBtn ;

	@FindBy(name="Delete")
	private WebElement DeleteBtn ;

	public WebElement getEditBtn() {
		return EditBtn;
	}

	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}

	//initialization
	public DocumentInfoPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}

}
