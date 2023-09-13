package utils;

import org.openqa.selenium.WebDriver;

import pages.CategoryPage;
import pages.MenuPage;
import pages.ProductPage;

public class BasePage  extends SeleniumWrappers{
	

	public BasePage(WebDriver driver) {
		super(driver);
	
	}
	public MenuPage menu =  new MenuPage(driver);
	public ProductPage product =  new ProductPage(driver);
	public CategoryPage category =  new CategoryPage(driver);
	
	
}