package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
	
	private WebDriver driver;
	private By nestedFramesLink = By.linkText("Nested Frames");

	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public FramesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	public NestedFramesPage clickNestedFramesLink() {
		driver.findElement(nestedFramesLink).click();
		return new NestedFramesPage(driver);
	}
}
