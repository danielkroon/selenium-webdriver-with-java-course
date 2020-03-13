package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
	
	private WebDriver driver;
	private By hotSpot = By.id("hot-spot");
	
	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void rightClickOnHotSpot() {
		WebElement hotspot =  driver.findElement(hotSpot);
		Actions actions = new Actions(driver);
		actions.contextClick(hotspot).perform();		
	}
	
	public String alert_gettext() {
		return driver.switchTo().alert().getText();
	}
	
	public void alert_clickOk() {
		 driver.switchTo().alert().accept();
	}
}
