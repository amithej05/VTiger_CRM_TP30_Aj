package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	

	@FindBy(id="submitButton")
	private WebElement lgBtn;
	
	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}
	
	//utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLgBtn() {
		return lgBtn;
	}
	
	//business logic
	public void loginToApp(String UN, String  PWd) {
		usernameEdt.sendKeys(UN);
		passwordEdt.sendKeys(PWd);
		lgBtn.click();
		
		
	}	
}
