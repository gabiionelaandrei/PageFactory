package pages;

import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class BasePage extends SeleniumWrappers{

	public static final String category = null;
	public BasePage(WebDriver driver) {
		super(driver);
	}

	public MenuPage menu =  new MenuPage(driver);
	public MyAccountPage myAccount = new MyAccountPage(driver);
	public ProductPage product = new ProductPage(driver);
	public CategoryPage categories = new CategoryPage(driver);
	public BlogPage blog = new BlogPage(driver);
}
