package tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

public class PostACommentBlogPage {

	@Listeners(TestNgListener.class)
	public class LoginTest extends BaseTest {

		@Test(priority = 1)
		public void addABlogComment() throws InterruptedException {

			app.click(app.menu.myAccountLink);
			app.myAccount.loginInApp("customer", "customer@123");
			assertTrue(app.checkElementIsDisplayed(app.myAccount.greetingsMessage));

			app.click(app.menu.backToHome);
			app.click(app.menu.blog);
			List<WebElement> blogList = new ArrayList<WebElement>();
			
			app.blog.blogPost(app.blog.tipsAndTricks, blogList);
			app.blog.blogPost(app.blog.groceryTypeFaces, blogList);
			app.blog.blogPost(app.blog.groceryBreakfast, blogList);
			app.blog.blogPost(app.blog.groceryProvideDenounce, blogList);
			assertTrue(blogList.size() == 4);

			app.blog.addComment(app.blog.tipsAndTricks, "This is a tipsAndTricks comment.");
			assertTrue(app.blog.commentPosted.getText().contains("Your comment is awaiting moderation."));
			driver.navigate().back();
			
			app.blog.addComment(app.blog.groceryTypeFaces, "This is a groceryTypeFaces comment.");
			assertTrue(app.blog.commentPosted.getText().contains("Your comment is awaiting moderation."));
			driver.navigate().back();
			
			app.blog.addComment(app.blog.groceryBreakfast, "This is a groceryBreakfast comment.");
			assertTrue(app.blog.commentPosted.getText().contains("Your comment is awaiting moderation."));
			driver.navigate().back();
	
			
			app.blog.addComment(app.blog.groceryProvideDenounce, "This is a groceryProvideDenounce comment.");
			assertTrue(app.blog.commentPosted.getText().contains("Your comment is awaiting moderation."));

		}
	}
}
