package cookies;

import base.BaseTests;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CookiesTests extends BaseTests {

    @Test
    public void testAddCookie() {
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie("tau", "123");
        cookieManager.addCookie(cookie);
        assertTrue(cookieManager.isCookiePresent(cookie));
    }

    @Test
    public void testDeleteCookie() {
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie("optimizelyBuckets", "%7B%7D");
        cookieManager.deleteCookie(cookie);
        assertFalse(cookieManager.isCookiePresent(cookie));
    }
}
