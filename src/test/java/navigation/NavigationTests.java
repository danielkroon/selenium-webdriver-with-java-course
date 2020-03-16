package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests{

	@Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack(); // getWindowManager comes from the BaseTests to get the driver.
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testRightClick() {
	    var Example2Page = homePage.clickDynamicLoading().rightClickExample2();
	    getWindowManager().switchToNewTab();
	    assertTrue(Example2Page.isStartButtonVisible(), "Start button is not visible.");
    }
}
