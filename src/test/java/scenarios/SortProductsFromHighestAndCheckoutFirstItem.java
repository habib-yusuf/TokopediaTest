package scenarios;

import org.testng.annotations.*;

import pages.BasePage;
import pages.CheckoutInformationPage;
import pages.CheckoutOverviewPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetails;
import pages.YourCartPage;

public class SortProductsFromHighestAndCheckoutFirstItem {
	
	BasePage pgBase = new BasePage();
	
	@BeforeTest
	public void openSite() {
		pgBase.setupBrowser("SortAndBuyProduct");
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		LoginPage pgLogin = new LoginPage();
		pgLogin.enterUsername("standard_user");
		pgLogin.enterPassword("secret_sauce");
		pgLogin.clickLogin();
		
		HomePage pgHome = new HomePage();
		pgHome.verifySuccessfulLogin();
	}
	
	@Test(priority = 2)
	public void sortProduct() throws InterruptedException {
		HomePage pgHome = new HomePage();
		pgHome.sortProductBy("Price (high to low)");
		pgHome.verifyProductSortedFormHighest();
		pgHome.clickFirstProduct();
	}
	
	@Test(priority = 3)
	public void buyTheProduct() throws InterruptedException {
		ProductDetails pgDetails = new ProductDetails();
		pgDetails.verifyProductName(BasePage.HIGHEST_PRODUCT_NAME);
		pgDetails.verifyProductPrice(BasePage.HIGHEST_PRODUCT_PRICE);
		pgDetails.clickAddToCartButton();
		pgDetails.clickShoppingCartButton();
		
		YourCartPage pgCart = new YourCartPage();
		pgCart.clickCheckoutButton();
		
		CheckoutInformationPage pgCheckout = new CheckoutInformationPage();
		pgCheckout.enterFirstName("Habib");
		pgCheckout.enterLastName("Yusuf");
		pgCheckout.enterPostCode("83521");
		pgCheckout.clickContinue();
		
		CheckoutOverviewPage pgOverview = new CheckoutOverviewPage();
		pgOverview.verifyCheckoutName(BasePage.HIGHEST_PRODUCT_NAME);
		pgOverview.verifyCheckoutPrice(BasePage.HIGHEST_PRODUCT_PRICE);
		
		//Capture screen
		pgBase.captureScreen();
		
		pgOverview.clickFinish();
		
		//Capture screen
		pgBase.captureScreen();
	}
	
	@AfterTest
	public void closeBrowser() {
		pgBase.terminateSession();
	}
}
