package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/*
 * Exercise chapter 6 https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter6.html
 */

public class HorizontalSliderPage {

	private WebDriver driver;
	private By sliderInput = By.tagName("input");
	private By sliderValue = By.id("range");
	
	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public HorizontalSliderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	public void setSlider(String sliderValue) {
		while(!getSliderValue().equals(sliderValue))
		driver.findElement(sliderInput).sendKeys(Keys.ARROW_UP);
	}
	
	public String getSliderValue() {
		return driver.findElement(sliderValue).getText();
	}
}
