package tests;


import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.TestNgListener;

public class WishProducts {
	@Listeners(TestNgListener.class)
	public class LoginTest  extends BaseTest{

		@Test(priority = 1)
		public void login() throws InterruptedException {
			
			app.click(app.menu.myAccountLink);
			app.myAccount.loginInApp("customer", "customer@123");
			assertTrue(app.checkElementIsDisplayed(app.myAccount.greetingsMessage));

			app.categories.addProduct(app.categories.melonFruit,app.categories.fruitsVegetables);
			app.categories.addProduct(app.categories.beconCheddar,app.categories.breakfastDairy);
			app.categories.addProduct(app.categories.almondBlend,app.categories.biscuitsSnacks);
			app.categories.addProduct(app.categories.zeroCalorieSoda,app.categories.beverages);
			
			app.categories.checkWishList(app.categories.melonFruitW);
			app.categories.checkWishList(app.categories.beconCheddarW);
			app.categories.checkWishList(app.categories.almondBlendW);
			app.categories.checkWishList(app.categories.zeroCalorieSodaW);

			
			app.categories.filterByValue("add_selected");
			
			assertTrue(app.categories.messageIsDisplayed(app.categories.messageProductNotSuccessfullyAdded, "Product “Zevia Kidz Strawberry Lemonade Zero Calorie Soda” could not be added to cart because some requirements are not met."));
			assertTrue(app.categories.messageIsDisplayed(app.categories.messageProductSuccessfullyAdded,"“Shimmer Pastel Almond Blend”, “Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar” and “Fresh Produce Melons Each” have been added to your cart."));
		}
		
	}
}
