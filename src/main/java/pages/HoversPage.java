package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

	private WebDriver driver;
	private By figureBox = By.className("figure");
	private By boxCaption = By.className("figcaption");
	
	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */
	
	public HoversPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// End constructor
	
	/**
	 * 
	 * @param index starts at 1
	 */
	
	public FigureCaption hoverOverFigure(int index) { // With int you can tell which figure you want to hover over
		WebElement figure = driver.findElements(figureBox).get(index - 1);
		
		Actions actions = new Actions(driver); // Create actions object so we can use the methods.
		actions.moveToElement(figure).perform();
		
		return new FigureCaption(figure.findElement(boxCaption));
	}
	
	/*
	 * Create a inner class for the figure caption because we can't return a WebElement to our tests.
	 * We place it inside this class since we won't use this FigureCaption outside it.
	 */
	
	
	public class FigureCaption {
		
		private WebElement caption;
		private By header = By.tagName("h5");
		private By link = By.tagName("a");
		
		public FigureCaption(WebElement caption) {
			this.caption = caption;
		}
		
		public boolean isCaptionDisplayed() {
			return caption.isDisplayed();
		}
		
		public String getTitle() {
			return caption.findElement(header).getText();
		}
		
		public String getLink() {
			return caption.findElement(link).getAttribute("href");
		}
		
		public String getLinkText() {
			return caption.findElement(link).getText();
		}
	}

}