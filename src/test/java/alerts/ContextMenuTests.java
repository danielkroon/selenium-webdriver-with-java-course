package alerts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTests;

public class ContextMenuTests extends BaseTests {

	@Test
	public void testrightClickOnHotSpot() {
		var ContextMenuPage = homePage.clickContextMenuPage();
		ContextMenuPage.rightClickOnHotSpot();
		var text = ContextMenuPage.alert_gettext();
		ContextMenuPage.alert_clickOk();
		assertEquals(text, "You selected a context menu", "Alert wrong text");
	}
}
