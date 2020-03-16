package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {
	
	private WebDriver driver;
	private By startButton = By.cssSelector("#start button");
	private By loadedText = By.id("finish");
	
	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public DynamicLoadingExample2Page(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	public void clickStart() {
		driver.findElement(startButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// Wait until element is present in the DOM
		wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
	}

	public String getLoadedText() {
		return driver.findElement(loadedText).getText();
	}

	public boolean isStartButtonVisible() {
		return driver.findElement(startButton).isDisplayed();
	}
}
