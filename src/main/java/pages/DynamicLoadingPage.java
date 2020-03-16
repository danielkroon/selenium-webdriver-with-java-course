package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {

	private WebDriver driver;
	/*
	 *  First create a Xpath String so it's more modular when selecting a example link with By. 
	 *  Since there are no ID's on the link.
	 */
	private String linkXpath_FormatString = ".//a[contains(text(), '%s')]";
	private By link_Example1 = By.xpath(String.format(linkXpath_FormatString, "Example 1"));
	private By link_Example2 = By.xpath(String.format(linkXpath_FormatString, "Example 2"));
	
	
	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	
	public DynamicLoadingExample1Page clickExample1() {
		driver.findElement(link_Example1).click();
		return new DynamicLoadingExample1Page(driver);
	}

	public DynamicLoadingExample2Page clickExample2() {
		driver.findElement(link_Example2).click();
		return new DynamicLoadingExample2Page(driver);
	}

	public DynamicLoadingExample2Page rightClickExample2() {
		driver.findElement(link_Example2).sendKeys(Keys.CONTROL, Keys.RETURN); // right click on the example 2 link and open new tab.
		return new DynamicLoadingExample2Page(driver);
	}
}
