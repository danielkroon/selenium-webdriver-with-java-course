package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
	private EventFiringWebDriver driver;
	/*
	 * Protected, so that test classes that inherit from this will have access to this homePage.
	 */
	protected HomePage homePage;
	
	/*
	 * We don't need a main method because TestNG will come in and find what it is that it want to run.
	 */
	
	// Annotation so this method will run before each of the test classes
	@BeforeClass 
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
		driver = new EventFiringWebDriver(new ChromeDriver()); // it is a ChromeDriver but wrap it in a EventFiringWebDriver so the EventFiringWebDriver can listen for events
		driver.register(new EventReporter()); // register a class that implements the webDriver event listener interface
		
		goHome();
	}
	
	// Make sure the tests starts at the homepage after each method
	@BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
	
	// Annotation so this method will run after each of the test classes
	@AfterClass 
	public void tearDown() {
		driver.quit();
	}

	@AfterMethod
	public void recordFailures(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			var camera = (TakesScreenshot)driver; // object to take a screenshot.
			File screenshot = camera.getScreenshotAs(OutputType.FILE); // save screenshot as a file.
			try { // wrap in a try catch because .move gives Unhandled exception: java.io.IOException
				Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}


	public WindowManager getWindowManager() {
		return new WindowManager(driver);
	}
}
