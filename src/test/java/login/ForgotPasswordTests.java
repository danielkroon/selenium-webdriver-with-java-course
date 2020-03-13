package login;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTests;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

/*
 * Exercise chapter 4.3 https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter4.3.html
 */

public class ForgotPasswordTests extends BaseTests {
	
	@Test
	public void testSuccesfullRetrievePassword() {
		ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
		forgotPasswordPage.setEmailAdressField("admin@example.com");
		EmailSentPage emailSentPage = forgotPasswordPage.clickRetrievePassword();
		
		assertTrue(emailSentPage.getMessage()
				.contains("Your e-mail's been sent!"),
				"Alert e-mail is not sent");
	}
}
