package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

	private WebDriver driver;
	private By statusAlert = By.id("flash");
	
	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public SecureAreaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	public String getAlert() {
		return driver.findElement(statusAlert).getText();	
	}
}
