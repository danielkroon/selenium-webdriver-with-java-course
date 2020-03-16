package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

/*
 * Extends BaseTests so it inherits from BaseTests
 */
public class LoginTests extends BaseTests {

	@Test
	public void testSuccesfullLogin() {
		/*
		 * Use homePage object that we inherited from BaseTests class.
		 * clickFormAuthentication() returns the LoginPage and we are moved to the page.
		 */
		LoginPage loginPage = homePage.clickFormAuthentication();
		loginPage.setUsername("tomsmith");
		loginPage.setPassword("SuperSecretPassword!");
		
		/*
		 * ClickLoginButton() returns the secureAreaPage and we are moved to the page.
		 * Make a variable for the secureAreaPage handle. 
		 */
		SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
		
		/*
		 * Use TestNG to verify the outcome since WebDriver only automates the actions in the browser. 
		 */
		assertTrue(secureAreaPage.getAlert()
				.contains("You logged into a secure area!"),
				"Alert text is incorrect");
	}
}
