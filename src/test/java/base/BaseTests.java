package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import utils.WindowManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
	private WebDriver driver;
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
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/");
		
		/*
		 * Once the application is launched we know we are on the home page so we created a new instance.
		 */
		homePage = new HomePage(driver);
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
	
	 public WindowManager getWindowManager() {
	        return new WindowManager(driver);
	    }
}
