package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	
	By username_textfield = By.xpath("//input[@placeholder='Username']");
	By password_textfield = By.xpath("//input[@placeholder='Password']");
	By login_button = By.xpath("//input[@id='login-button']");
	
	public void enterUsername(String username) {
		enterText(username_textfield, username);
	}
	
	public void enterPassword(String password) {
		enterText(password_textfield, password);
	}
	
	public void clickLogin() {
		clickElement(login_button);
	}
}
