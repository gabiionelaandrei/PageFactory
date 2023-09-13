package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

public class PlaceAnOrderAsARegisteredCustomer {
	@Listeners(TestNgListener.class)
	public class LoginTest  extends BaseTest{

		@Test(priority = 1)
		public void login() throws InterruptedException {
			
			app.click(app.menu.myAccountLink);
			app.myAccount.loginInApp("customer", "customer@123");
			assertTrue(app.checkElementIsDisplayed(app.myAccount.greetingsMessage));
			
			Actions action =  new Actions(driver);
			action.click(app.menu.backToHome).perform();
			app.menu.search("Pretzels");
			
			app.product.addToCartMessage.click();
			assertTrue(app.product.messageIsDisplayed(app.product.message, "“Rold Gold Tiny Twists Pretzels” has been added to your cart."));
			
			app.product.viewCart.click();
			
		
			String oldPrice = app.product.getText(app.product.updatePrice);
			app.product.quantity.click();
			app.product.updateCart.click();
			Thread.sleep(3000);
			String newPrice = app.product.getText(app.product.updatePrice);
			assertFalse(newPrice.equals(oldPrice));
			
			app.product.checkout.click();
			Thread.sleep(3000);
			app.product.terms.click();
			app.product.placeOrder.click();
			
			app.product.orderMessage.isDisplayed();
			assertTrue(app.product.messageIsDisplayed(app.product.orderMessage, "Thank you. Your order has been received."));
			assertFalse(app.product.getText(app.product.orderNumber).isEmpty());
			
		}
		
	}
}
