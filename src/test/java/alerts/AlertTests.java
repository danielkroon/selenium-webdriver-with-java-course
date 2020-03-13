package alerts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTests;

public class AlertTests extends BaseTests{

	@Test
	public void testAcceptAlert() {
		var AlertsPage = homePage.clickAlertsPage();
		AlertsPage.triggerAlert();
		AlertsPage.alert_clickToAccept();
		assertEquals(AlertsPage.getClickedAlertMessage(), "You successfuly clicked an alert", "Alert incorrect message");
	}
	
	@Test
	public void testGetTextFromAlert() {
		var AlertsPage = homePage.clickAlertsPage();
		AlertsPage.triggerConfirm();
		String text = AlertsPage.alert_getText();
		AlertsPage.alert_clickToDismiss();
		assertEquals(text, "I am a JS Confirm", "Alert the text is incorrect");
	}
	
	@Test
	public void testSetInputInAlert(){
		var alertsPage = homePage.clickAlertsPage();
		alertsPage.triggerPrompt();
	
	    String text = "WebDriver is awesome";
	    alertsPage.alert_setInput(text);
	    alertsPage.alert_clickToAccept();
	    assertEquals(alertsPage.getClickedAlertMessage(), "You entered: " + text, "Results text incorrect");
	}
}
