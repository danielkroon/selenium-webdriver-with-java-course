package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Exercise chapter 4.3 https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter4.3.html
 */

public class EmailSentPage {
	private WebDriver driver;
	private By message = By.id("content");
	
	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public EmailSentPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	public String getMessage() {
		return driver.findElement(message).getText();	
	}
}
