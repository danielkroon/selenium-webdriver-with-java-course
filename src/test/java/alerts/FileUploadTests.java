package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests  extends BaseTests{

	@Test
	public void tetFileUpload() {
		var uploadPage = homePage.clickFileUploadPage();
		uploadPage.uploadFile("/Users/dkroon/IntelliJ Projects/tau-selenium-webdriver-tutorial-java/resources/chromedriver");
		assertEquals(uploadPage.getUploadedFiles(), "chromedriver", "Upload failed");
	}
}
