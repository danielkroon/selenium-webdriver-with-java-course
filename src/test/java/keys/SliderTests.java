package keys;

import static org.testng.Assert.assertEquals;

/*
 * Exercise chapter 6 https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter6.html
 */

import org.testng.annotations.Test;

import base.BaseTests;

public class SliderTests  extends BaseTests{

	@Test
	public void testMoveSlider() {
		String sliderValue  = "4";
		var horizontalSliderPage = homePage.clickHorizontalSlider();
		horizontalSliderPage.setSlider(sliderValue);
		
		assertEquals(horizontalSliderPage.getSliderValue(), sliderValue, "Alert slider value is incorrect");
	}
}
