package pages;

import org.openqa.selenium.By;

public class ProductDetails extends BasePage {
	
	By product_name = By.xpath("//div[@class='inventory_details_name large_size']");
	By product_price = By.xpath("//div[@class='inventory_details_price']");
	By add_to_cart = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
	By cart_icon = By.xpath("//a[@class='shopping_cart_link']");
	
	public void verifyProductName(String productName) throws InterruptedException {
		verifyDisplayedText(product_name, productName);
		System.out.println("Correct product name: "+productName);
	}
	
	public void verifyProductPrice(String productPrice) throws InterruptedException {
		verifyDisplayedText(product_price, productPrice);
		System.out.println("Correct product price: "+productPrice);
	}
	
	public void clickAddToCartButton() {
		clickElement(add_to_cart);
	}
	
	public void clickShoppingCartButton() {
		clickElement(cart_icon);
	}
}
