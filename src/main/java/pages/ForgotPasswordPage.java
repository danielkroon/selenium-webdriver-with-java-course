package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Exercise chapter 4.3 https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter4.3.html
 */

public class ForgotPasswordPage {

	private WebDriver driver;
	private By emailAdressField = By.id("email");
	private By retrievePassword = By.id("form_submit");
	
	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	public void setEmailAdressField(String email) {
		driver.findElement(emailAdressField).sendKeys(email);
	}
	
	public EmailSentPage clickRetrievePassword() {
		driver.findElement(retrievePassword).click();
		return new EmailSentPage(driver);
	}	
}
