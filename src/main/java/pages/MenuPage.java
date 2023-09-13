package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers {

	public MenuPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
																																																				
	/* public By myAccountLink = By.linkText("My account");
	 * 
	 * myAccountLink --> locator
	 * 
	 * driver.findElement(myAccountLink) --> WebElement
	 * 
	 */
	
	@FindBy(linkText = "My account") public WebElement myAccountLink;
	@FindBy(css="a[href='https://keyfood.ro']")
	public WebElement backToHome;
	
	@FindBy(id = "dgwt-wcas-search-input-1") 
	public WebElement searchTab;
	
	@FindBy(xpath = "//div[@class='header-canvas button-item']/a/i") 
	public WebElement menusTab;
	

	
	
	
	public void search(String text) {
		Actions action =  new Actions(driver);
		searchTab.click();
		searchTab.clear();
		searchTab.sendKeys(text);
		action.sendKeys(Keys.ENTER)
		.perform();

	}
}