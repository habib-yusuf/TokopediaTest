package pages;

import org.openqa.selenium.By;

public class CheckoutInformationPage extends BasePage {

	By first_name_field = By.xpath("//input[@name='firstName']");
	By last_name_field = By.xpath("//input[@name='lastName']");
	By post_code_field = By.xpath("//input[@name='postalCode']");
	By continue_button = By.xpath("//input[@name='continue']");
	
	public void enterFirstName(String firstName) {
		enterText(first_name_field, firstName);
	}
	
	public void enterLastName(String lastName) {
		enterText(last_name_field, lastName);
	}
	
	public void enterPostCode(String postCode) {
		enterText(post_code_field, postCode);
	}
	
	public void clickContinue() {
		clickElement(continue_button);
	}
	
}
