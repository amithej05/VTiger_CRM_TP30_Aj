
package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage {

	//declaration
	@FindBy(xpath="//img[@title='Create Ticket...']")
	private WebElement createTicketBtn;

	@FindBy(xpath="//textarea[@name='ticket_title']")
	private WebElement titleTf;

	@FindBy(name="ticketpriorities")
	private WebElement priorDpDown;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name="ticketseverities")
	private WebElement severDpDown;

	@FindBy(name="Export")
	private WebElement ExportBtn;
	
	@FindBy(xpath="//img[@title='Export Trouble Tickets']")
	private WebElement troubleTicketBtn;


	//initialization
	public TroubleTicketPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}

	//utilization
	public WebElement getCreateTicketBtn() {
		return createTicketBtn;
	}

	public WebElement getTitleTf() {
		return titleTf;
	}

	public WebElement getPriorDpDown() {
		return priorDpDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSeverDpDown() {
		return severDpDown;
	}

	public WebElement getExportBtn() {
		return ExportBtn;
	}
	

	public WebElement getTroubleTicketBtn() {
		return troubleTicketBtn;
	}

	public void ticketCreation(String title) {
		titleTf.sendKeys(title);
	}

}
