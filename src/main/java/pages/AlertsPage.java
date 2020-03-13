package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

	private WebDriver driver;
	private By triggerAlertButtonBy = By.xpath(".//button[text()='Click for JS Alert']");
	private By triggerConfirmButtonBy = By.xpath(".//button[text()='Click for JS Confirm']");
	private By triggerPromptButton = By.xpath(".//button[text()='Click for JS Prompt']");
	
	private By resultMessage = By.id("result");
	
	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public AlertsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	public void triggerAlert() {
		driver.findElement(triggerAlertButtonBy).click();
	}
	
	public void triggerConfirm() {
		driver.findElement(triggerConfirmButtonBy).click();
	}
	
	public void triggerPrompt(){
        driver.findElement(triggerPromptButton).click();
    }
	
	// Can't use driver.findelement because it's not a webElement.
	public void alert_clickToAccept() {
		// switch from the DOM to something else
		driver.switchTo().alert().accept();
	}
	
	public void alert_clickToDismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	public String alert_getText() {
		return driver.switchTo().alert().getText();
	}
	public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }
	
	public String getClickedAlertMessage() {
		return driver.findElement(resultMessage).getText();
	}
}
