package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExportTroubleTicketPage {
	
	@FindBy(name="Export")
	private WebElement exportTroubleTicketBtn;
	
	//initialization
		public ExportTroubleTicketPage(WebDriver driver) {
			PageFactory.initElements( driver, this);
		}

		public WebElement getExportTroubleTicketBtn() {
			return exportTroubleTicketBtn;
		}
		
		
}
