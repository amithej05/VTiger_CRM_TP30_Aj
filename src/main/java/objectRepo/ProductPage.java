package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductBtn;
	
	@FindBy(name="productname")
	private WebElement productTf;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//initialization
	public ProductPage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}

	//utilization
	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}
	
	
	
	public WebElement getProductTf() {
		return productTf;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createProduct(String ProductName) {
		productTf.sendKeys(ProductName);
		saveBtn.click();
	}
	
}
