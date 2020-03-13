package base;

import org.testng.annotations.BeforeMethod;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Exercise chapter 3 https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter3.html
 */

public class ShiftingContent {
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		WebElement shiftingLinkElement =  driver.findElement(By.linkText("Shifting Content"));
		shiftingLinkElement.click();
		
		WebElement firstMenuElement = driver.findElement(By.linkText("Example 1: Menu Element"));
		firstMenuElement.click();
		
		List<WebElement> menu = driver.findElements(By.tagName("li"));
		System.out.println(menu.size());

		driver.quit();
	}

	public static void main(String[] args) {
		ShiftingContent testsChapter3 = new ShiftingContent();
		testsChapter3.setUp();
	}
}
