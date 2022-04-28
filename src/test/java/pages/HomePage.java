package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	
	By sort_dropdown = By.xpath("//select[@class='product_sort_container']");
	By product_titles = By.xpath("//div[@class='inventory_item_name']");
	By product_prices = By.xpath("//div[@class='inventory_item_price']");
	
	public void sortProductBy(String option) {
		selectDropdown(sort_dropdown, option);
	}
	
	public void clickFirstProduct() {
		clickElement(product_titles);
	}
	
	public String[] getProductName() {
		List<WebElement> names = driver.findElements(product_titles);
		String[] txtNames = new String[names.size()];
		int a = 0;
		for(WebElement b : names) {
			txtNames[a] = b.getText();
			a+=1;
		}
		return txtNames;
	}
	
	public String[] getProductPrice() {
		List<WebElement> prices = driver.findElements(product_prices);
		String[] txtPrices = new String[prices.size()];
		int a = 0;
		for(WebElement b : prices) {
			txtPrices[a] = b.getText();
			a+=1;
		}
		return txtPrices;
	}
	
	public void verifySuccessfulLogin() throws InterruptedException {
		if(verifyShown(sort_dropdown)){
			System.out.println("Successfully logged in!");
		} else {
			System.out.println("Log in failed!");
		}
	}
	
	public void verifyProductSortedFormHighest() throws InterruptedException {
		int itr = 0;
		boolean sorted = false;
		
		do {
			Thread.sleep(500);
			
			String[] names = getProductName();
			String[] prices = getProductPrice();
			double[] doublePrices = new double[prices.length];
			int a = 0;
			
			HIGHEST_PRODUCT_NAME = names[0];
			HIGHEST_PRODUCT_PRICE = prices[0];
			
			for(String b : prices) {
				doublePrices[a] = Double.parseDouble(b.replace("$", ""));
				a+=1;
			}
			
			for(int c = 1; c < doublePrices.length; c++) {
				if(doublePrices[c] <= doublePrices[c-1]) {
					sorted = true;
				} else {
					sorted = false;
					break;
				}
			}
			
			itr+=1;
		} while ((itr < 6) && (sorted == false));

		if(sorted) {
			
			System.out.println("Products are successfully sorted from Highest to Lowest");
		} else {
			System.out.println("Products ARE NOT successfully sorted from Highest to Lowest");
		}
	}
}
