package pages;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public static WebDriver driver = null;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmm");
	private static Timestamp timestamp = null;
	public static String HIGHEST_PRODUCT_NAME = null;
	public static String HIGHEST_PRODUCT_PRICE = null;
	public static String SCENARIO_NAME = null;
	public static int IMG_COUNT = 0;
	
	public void setupBrowser(String scenarioName) {
		
		timestamp = new Timestamp(System.currentTimeMillis()); 
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver(); 
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		SCENARIO_NAME = scenarioName;
	}
	
	public void enterText(By xpath, String text) {
		try {
			verifyShown(xpath);
			driver.findElement(xpath).sendKeys(text);
			
			System.out.println("Successfully entered: "+text);
		} catch (Exception e) {
			System.out.println("FAILED! Enter " + text +
					"\nERROR: " + e);
			terminateSession();
		}
	}
	
	public void selectDropdown(By xpath, String option) {
		try {
			verifyShown(xpath);
			Select item = new Select(driver.findElement(xpath));
			item.selectByVisibleText(option);
			
			System.out.println("Successfully selected: "+option);
		} catch (Exception e) {
			System.out.println("FAILED! Enter " + option +
					"\nERROR: " + e);
			terminateSession();
		}
	}
	
	public void clickElement(By xpath) {
		try {
			verifyShown(xpath);
			driver.findElement(xpath).click();
			
			System.out.println("Successfully clicking "+xpath.toString());
		} catch (Exception e) {
			System.out.println("FAILED! clicking "+xpath.toString() +
					"\nERROR: " + e);
			terminateSession();
		}
	}
	
	public boolean verifyShown(By xpath) throws InterruptedException {
		boolean found = false;
		int lmnCount = 0;
		int itr = 0;
		
		do {
			Thread.sleep(200);
			lmnCount = driver.findElements(xpath).size();
			itr+=1;
			
			if(lmnCount>0) {
				found = true;
			}
			
		}while((lmnCount < 1) && (itr <= 50));
		
		if(!found) {
			System.out.println("Element not found "+xpath.toString());
			terminateSession();
		}
		
		return found;
	}
	
	public boolean verifyDisplayedText(By xpath, String text) throws InterruptedException {
		boolean correct = false;
		
		verifyShown(xpath);
		if(getElementText(xpath).trim().toLowerCase().equals(text.trim().toLowerCase())) {
			correct = true;
			System.out.println("Text displayed match!");
		} else {
			terminateSession();
			System.out.println("Text displayed UNMATCH!");
		}
		return correct;
	}
	
	public String getElementText(By xpath) throws InterruptedException {
		verifyShown(xpath);
		String strText = driver.findElement(xpath).getText();
		System.out.println("Text retrieved from the element..");
		return strText;
	}
	
	public void captureScreen() {
		
		IMG_COUNT+=1;
		String counter = ("000" + Integer.toString(IMG_COUNT)).substring(1);
		String fullPath = System.getProperty("user.dir")+"\\ScreenCaptures\\"+SCENARIO_NAME+dateFormat.format(timestamp)+"\\"+counter+".png";
		File imgPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(imgPath, new File(fullPath));
		} catch (IOException e) {
            System.out.println(e.getMessage());
        }
		
	}
	
	public void terminateSession() {
		
		driver.close();
		driver.quit();
		
	}
	
}
