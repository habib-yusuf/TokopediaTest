package pages;

import org.openqa.selenium.By;

public class YourCartPage extends BasePage {
	
	By checkout_button = By.xpath("//button[@id='checkout']");
	
	public void clickCheckoutButton() {
		clickElement(checkout_button);
	}
}
