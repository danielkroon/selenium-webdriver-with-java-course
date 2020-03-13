package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class DynamicLoadingExample1Page {

	private WebDriver driver;
	private By startButton = By.cssSelector("#start button");
	private By loadingIndicator  = By.id("loading");
	private By loadedText = By.id("finish");
	
	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public DynamicLoadingExample1Page(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	public void clickStart() {
		driver.findElement(startButton).click();
		
		/*
		 * 	Option 1: 
		 * 	Wait up until 5 seconds for the loading indicator to be invisible. 5 seconds is a timeout.
		 * 	WebDriverWait wait = new WebDriverWait(driver, 5);
		 * 	wait.until(ExpectedConditions.invisibilityOf(
					driver.findElement(loadingIndicator)));
		 */

		/*
		 *  Option 2:
		 *  More fluent way to check every second if the element is there.
		 *  If the element is not present in the DOM and we try to find it before it is there. 
		 *  Than it throws the NoSuchElementException. We ignore that.
		 */
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.invisibilityOf(
				driver.findElement(loadingIndicator)));	
	}
	
	public String getLoadedText() {
		return driver.findElement(loadedText).getText();
		
	}
}
