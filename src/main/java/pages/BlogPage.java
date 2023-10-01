package pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers {

	public BlogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='entry-title']/a[@href='https://keyfood.ro/2021/05/03/but-i-must-explain-to-you-how-all-this-mistaken-idea/']")
	public WebElement tipsAndTricks;
	
	@FindBy(xpath = "//h2[@class='entry-title']/a[@href='https://keyfood.ro/2021/05/03/the-problem-with-typefaces-on-the-web/']")
	public WebElement groceryTypeFaces;
	
	@FindBy(xpath = "//h2[@class='entry-title']/a[@href='https://keyfood.ro/2021/05/02/english-breakfast-tea-with-tasty-donut-desserts/']")
	public WebElement groceryBreakfast;
	
	@FindBy(xpath = "//h2[@class='entry-title']/a[@href='https://keyfood.ro/2021/05/01/on-the-other-hand-we-provide-denounce-with-righteous/']")
	public WebElement groceryProvideDenounce;
	@FindBy(id="comment")
	public WebElement comment;
	@FindBy(id="submit")
	public WebElement submit;
	@FindBy(xpath = " //em") 
	public WebElement commentPosted;
	
	public void blogPost(WebElement element, List<WebElement> blogPostList) {
		blogPostList.add(element);
	
	}	
	
	public void addComment(WebElement element, String message) throws InterruptedException {
		element.click();
		comment.sendKeys(message);
		submit.click();
	    Thread.sleep(3000);
		driver.navigate().back();
        Thread.sleep(3000);
	}	

}
