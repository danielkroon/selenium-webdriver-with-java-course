package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	/*
	 * Create constructor that specify you must pass in the WebDriver when you instantiate this class. 
	 */
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage clickFormAuthentication() {
		clickLink("Form Authentication"); // call linkText method
		return new LoginPage(driver);
	} 
	
	public DropDownPage clickDropDown() {
		clickLink("Dropdown");
		return new DropDownPage(driver);
	}
	
	public ForgotPasswordPage clickForgotPassword() {
		clickLink("Forgot Password");
		return new ForgotPasswordPage(driver);
	}
	
	public HoversPage clickHoverPage() {
		clickLink("Hovers");
		return new HoversPage(driver);
	}
	
	public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
	
	public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }
	
	public AlertsPage clickAlertsPage() {
		clickLink("JavaScript Alerts");
		return new AlertsPage(driver);
	}
	
	public FileUploadPage clickFileUploadPage() {
		clickLink("File Upload");
		return new FileUploadPage(driver);
	}
	
	public ContextMenuPage clickContextMenuPage() {
		clickLink("Context Menu");
		return new ContextMenuPage(driver);
	}
	
	public WysiwygEditorPage clickWysiwygEditor() {
		clickLink("WYSIWYG Editor");
		return new WysiwygEditorPage(driver);
	}
	
	public FramesPage clickFramesPage() {
		clickLink("Frames");
		return new FramesPage(driver);
	}
	
	public DynamicLoadingPage clickDynamicLoading() {
		clickLink("Dynamic Loading");
		return new DynamicLoadingPage(driver);
	}
	
	public LargeAndDeepDomPage clickLargeAndDeepDom() {
		clickLink("Large & Deep DOM");
		return new LargeAndDeepDomPage(driver);
	}
	
	public InfiniteScrollPage clickInfiniteScroll() {
		clickLink("Infinite Scroll");
		return new InfiniteScrollPage(driver);
	}
	
	public MultipleWindowsPage clickMultipleWindows() {
		clickLink("Multiple Windows");
		return new MultipleWindowsPage(driver);
	}
	
	private void clickLink(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}
}
