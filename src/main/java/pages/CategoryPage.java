package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.Log;
import utils.SeleniumWrappers;

public class CategoryPage extends SeleniumWrappers{
	public CategoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(), 'ALL CATEGORIES' )]") 
	public WebElement categoriesMenu;
	
	@FindBy(xpath = "//li[@class='category-parent  menu-item menu-item-type-taxonomy menu-item-object-product_cat']/a") 
	public WebElement fruitsVegetables;
	
	@FindBy(xpath = "//li[@class='category-parent  menu-item menu-item-type-taxonomy menu-item-object-product_cat']/a[contains(text(), 'Breakfast & Dairy' )]") 
	public WebElement breakfastDairy;
	
	@FindBy(xpath = "//li[@class='category-parent  menu-item menu-item-type-taxonomy menu-item-object-product_cat']/a[contains(text(), 'Biscuits & Snacks' )]") 
	public WebElement biscuitsSnacks;
	
	@FindBy(xpath = "//li[@class='category-parent  menu-item menu-item-type-taxonomy menu-item-object-product_cat']/a[contains(text(), 'Beverages' )]") 
	public WebElement beverages;
	
	
	
	@FindBy(xpath = "//img[@alt='Fresh Produce Melons Each']") 
	public WebElement melonFruit;
	@FindBy(xpath = "//img[@alt='Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar']") 
	public WebElement beconCheddar;
	@FindBy(xpath = "//img[@alt='Shimmer Pastel Almond Blend']") 
	public WebElement almondBlend;
	@FindBy(xpath = "//img[@alt='Zevia Kidz Strawberry Lemonade Zero Calorie Soda']") 
	public WebElement zeroCalorieSoda;
	
	//wishlist
	
	@FindBy(xpath = "//a[contains(text(),'Fresh Produce Melons Each')]") 
	public WebElement melonFruitW;
	@FindBy(xpath = "//a[contains(text(),'Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar')]") 
	public WebElement beconCheddarW;
	@FindBy(xpath = "//a[contains(text(),'Shimmer Pastel Almond Blend')]") 
	public WebElement almondBlendW;
	@FindBy(xpath = "//a[contains(text(),'Zevia Kidz Strawberry Lemonade Zero Calorie Soda')]") 
	public WebElement zeroCalorieSodaW;
	
	@FindBy(xpath = "//div[@class='product-actions']/div/div[@class ='tinv-wishlist-clear']/following::a[@aria-label='Add to Wishlist']") 
	public WebElement wishButton;
	
	@FindBy(xpath = "//button[@class='button tinvwl_button_close']") 
	public WebElement closeButton;
	
	@FindBy(xpath = "//button[@class='button tinvwl_button_close']") 
	public WebElement alreadyInList;
	
	@FindBy(xpath = "//a[contains(text(),'Wishlist')]") 
	public WebElement wishList;
	@FindBy(xpath = "//span[contains(text(), 'Add to Cart')]") 
	public WebElement addToCart;
	
	@FindBy(xpath = "//span[contains(text(), 'Buy product')]") 
	public WebElement buyProduct;
	@FindBy(name = "product_actions") 
	public WebElement actions;
	
	@FindBy(xpath = "//button[contains(text(), 'Apply')]") 
	public WebElement applyButton;
	
	@FindBy(xpath = "//input[@title='Select all for bulk action']") 
	public WebElement selectAll;
	
	@FindBy(xpath = "//li[contains(text(),'Product “Zevia Kidz Strawberry Lemonade Zero Calorie Soda” could not be added to cart because some requirements are not met.')]") 
	public WebElement messageProductNotSuccessfullyAdded;
	
	@FindBy(xpath = "//div[@class='woocommerce-message']") 
	public WebElement messageProductSuccessfullyAdded;

	public void addProduct(WebElement produs, WebElement category ) {
		
		categoriesMenu.click();
		category.click();
		produs.click();
		try {
			 wishButton.click();
			
		}catch (Exception alreadyInList) {
			closeButton.click();
		}
	
		closeButton.click();
		
	}
	
	public void checkWishList(WebElement element) {
		
		List <WebElement> wishElements = new ArrayList<WebElement>();
		wishElements.add(melonFruitW);
		wishElements.add(beconCheddarW);
		wishElements.add(almondBlendW);
		wishElements.add(zeroCalorieSodaW);
		wishList.click();
		
		for (WebElement product : wishElements) {
			if(product.getText().equals(melonFruitW.getText()) || product.getText().equals(beconCheddarW.getText()) || product.getText().equals(almondBlendW.getText())){
				
				assertTrue(checkElementIsDisplayed(addToCart));
			}
			else {
				assertTrue(checkElementIsDisplayed(buyProduct));
			}

        }
		
	}

	public void filterByValue(String value) {
		selectAll.click();
		actions.click();
		Select dropdown =  new Select(actions);
		dropdown.selectByValue(value);
		applyButton.click();
		
	}
	
	public boolean messageIsDisplayed(WebElement element, String string) {		
		return element.getText().contains(string);
	}
	
}