package javascript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;
import base.BaseTests;

public class JavaScriptTests extends BaseTests {

	@Test
	public void testScrollToTable() {
		homePage.clickLargeAndDeepDom().scrollToTable();
	}
	
	@Test
	public void testScrollToFifthParagraph() {
		homePage.clickInfiniteScroll().scrollToParagraph(5);
	}
	
	@Test
	public void testAddMultipleAttributeToDropdown() {
		var dropDownPage = homePage.clickDropDown();
		dropDownPage.addMultipleAttribute();
		
		/*
		 * String option1 = "Option 1";
		 * String option2 = "Option 2";
		 * dropDownPage.selectFromDropDown(option1);
		 * dropDownPage.selectFromDropDown(option2);
		
		 * var selectedOptions = dropDownPage.getSelectedOptions();
		 * assertTrue(selectedOptions.contains(option1), "Option 1 was not selected");
		 * assertTrue(selectedOptions.contains(option2), "Option 2 was not selected");
		 * assertEquals(selectedOptions.size(), 2);
		 */
		
		var optionsToSelect = List.of("Option 1", "Option 2");
		optionsToSelect.forEach(dropDownPage::selectFromDropDown);

        var selectedOptions = dropDownPage.getSelectedOptions();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
	}
}
