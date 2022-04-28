package pages;

import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage {
	
	By checkout_item_name = By.xpath("//div[@class='inventory_item_name']");
	By checkout_item_price = By.xpath("//div[@class='inventory_item_price']");
	By finish_button = By.xpath("//button[@id='finish']");
	
	public void verifyCheckoutName(String productName) throws InterruptedException {
		verifyDisplayedText(checkout_item_name, productName);
		System.out.println("Correct product name: "+productName);
	}
	
	public void verifyCheckoutPrice(String productPrice) throws InterruptedException {
		verifyDisplayedText(checkout_item_price, productPrice);
		System.out.println("Correct product price: "+productPrice);
	}
	
	public void clickFinish() {
		clickElement(finish_button);
	}
	
}
