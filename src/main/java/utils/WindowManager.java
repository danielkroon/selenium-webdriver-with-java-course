package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

	private WebDriver driver;
	private WebDriver.Navigation navigate;

	/*
	 * Create constructor to receive the WebDriver because this class also needs a WebDriver
	 */

	public WindowManager(WebDriver driver) {
		this.driver = driver;
		navigate = driver.navigate();
	}

	// End constructor

	public void goBack() {
		navigate.back();
	}

	public void goForward() {
		navigate.forward();
	}

	public void refreshPage() {
		navigate.refresh();
	}

	public void goTo(String url) {
		navigate.to(url);
	}

	public void switchToTab(String tabTitle) {
		var windows = driver.getWindowHandles();

		System.out.println("Number of tabs: " + windows.size());

		System.out.println("Window handles:");
		windows.forEach(System.out::println);

		for (String window : windows) {
			System.out.println("Switching to window: " + window);
			driver.switchTo().window(window);

			System.out.println("Current window title: " + driver.getTitle());

			if (tabTitle.equals(driver.getTitle())) {
				break;
			}
		}
	}

	public void switchToNewTab() {
		var windows = driver.getWindowHandles();
		windows.forEach(driver.switchTo()::window);
	}
}
