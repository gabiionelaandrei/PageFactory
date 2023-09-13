package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class ProductPage extends SeleniumWrappers{
	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="add-to-cart") 
	public WebElement addProduct;
	@FindBy(name="add-to-cart") 
	public WebElement addToCartMessage;
	
	@FindBy(xpath="//div[contains(a/following-sibling::text(), 'has been added to your cart')]")
	public WebElement message;
	
	@FindBy(xpath="//div/a[text()= 'View cart']")
	public WebElement viewCart;

	@FindBy(xpath="//div[label[contains(text(), 'Rold Gold Tiny Twists Pretzels')]]/div/i[@class='klbth-icon-plus']")
	public WebElement quantity;
	
	@FindBy(xpath="//button[contains(text(), 'Update cart' )]")
	public WebElement updateCart;
	
	@FindBy(xpath="//div[@class='cart-price']/span[@class='woocommerce-Price-amount amount']/bdi")
	public WebElement updatePrice;
	
	@FindBy(xpath="//a[contains(text(), 'Proceed to checkout' )]")
	public WebElement checkout;
	
	@FindBy(id="terms") 
	public WebElement terms;
	
	@FindBy(id="place_order") 
	public WebElement placeOrder;
	
	@FindBy(xpath="//p[contains(text(), 'Thank you. Your order has been received.' )]")
	public WebElement orderMessage;
	
	@FindBy(xpath="//li[@class='woocommerce-order-overview__order order']/strong")
	public WebElement orderNumber;
	
	
	public boolean messageIsDisplayed(WebElement element, String string) {		
		return element.getText().contains(string);
	}
	
	public String getText(WebElement element) {
		
		return element.getText();
	}

}


