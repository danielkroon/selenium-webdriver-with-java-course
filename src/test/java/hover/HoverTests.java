package hover;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTests;

public class HoverTests extends BaseTests {

	@Test
	public void testHoverUser1() {
		var hoversPage = homePage.clickHoverPage();
		var caption = hoversPage.hoverOverFigure(1);
		assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
		assertEquals(caption.getTitle(), "name: user1", "Caption title is incorrect");
		assertEquals(caption.getLinkText(), "View profile", "Caption link text is incorrect");
		assertTrue(caption.getLink().endsWith("/users/1"), "Link is incorrect");
	}
}
