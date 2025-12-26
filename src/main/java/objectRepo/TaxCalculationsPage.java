package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaxCalculationsPage {

	
	//declaration
		@FindBy(xpath="//td[@id='td_add_tax']/input[@title='Add Tax']")
		private WebElement addTaxBtn;
		
		@FindBy(id="addTaxLabel")
		private WebElement taxNametf;
		
		@FindBy(id="addTaxValue")
		private WebElement taxValuetf;
		
		@FindBy(name="Save")
		private WebElement SaveBtn;
		
		//initialization
		public TaxCalculationsPage(WebDriver driver) {
			PageFactory.initElements( driver, this);
		}

		public WebElement getAddTaxBtn() {
			return addTaxBtn;
		}

		public WebElement getTaxNametf() {
			return taxNametf;
		}

		public WebElement getTaxValuetf() {
			return taxValuetf;
		}

		public WebElement getSaveBtn() {
			return SaveBtn;
		}
		
		public void addTax(String name) throws InterruptedException {
			taxNametf.clear();
			taxNametf.sendKeys(name);
			taxValuetf.clear();
			taxValuetf.sendKeys("10");
			SaveBtn.click();		
			Thread.sleep(2000);
		}
		
}
