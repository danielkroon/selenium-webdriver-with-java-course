package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {

	private WebDriver driver;
	private By dropdown = By.id("dropdown");
	
	public DropDownPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectFromDropDown(String option) {
		findDropdownElement().selectByVisibleText(option);
	}
	
	public List <String> getSelectedOptions() {
		List <WebElement> selectedElementsList =
				findDropdownElement().getAllSelectedOptions();
		/*
		 * For every element(e) that's inside of this list I want you to take this action(->).
		 * The action is to get the text. 
		 * Then collect all of those and add to a new list of Strings.
		 */
		return selectedElementsList.stream().map(e->e.getText()).collect(Collectors.toList()); 
	}
	
	public void addMultipleAttribute( ) {
		String script = "arguments[0].setAttribute('multiple', '')";
		var jsExecutor = (JavascriptExecutor)driver;
		
		WebElement dropDownElement = driver.findElement(dropdown);
		jsExecutor.executeScript(script, dropDownElement);
	}
	
	
	private Select findDropdownElement() {
		return new Select(driver.findElement(dropdown)); // use Selenium Support to get Select
	}
}
