package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
		
	@FindBy(partialLinkText="Tax Calculations")
	private WebElement TaxCalculationsBtn ; 
	
	//initialization
		public SettingsPage(WebDriver driver) {
			PageFactory.initElements( driver, this);
		}

		//utilization
		public WebElement getTaxCalculationsBtn() {
			return TaxCalculationsBtn;
		}
		
		

}
