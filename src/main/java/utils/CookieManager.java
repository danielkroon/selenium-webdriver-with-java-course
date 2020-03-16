package utils;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieManager {

    private WebDriver driver;

    /*
     * Create constructor to receive the WebDriver because this class also needs a WebDriver
     */

    public CookieManager(WebDriver driver) {
        this.driver = driver;
    }

    // End constructor

    public void addCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    public boolean isCookiePresent(Cookie cookie){
        return driver.manage().getCookieNamed(cookie.getName()) != null;
    }

    public void deleteCookie(Cookie cookie) {
        driver.manage().deleteCookie(cookie);
    }

    public Cookie buildCookie(String name, String value){
        Cookie cookie = new Cookie.Builder(name, value)
                .domain("the-internet.herokuapp.com")
                .build(); // creates the cookie but isn't set yet.
        return cookie;
    }
}
