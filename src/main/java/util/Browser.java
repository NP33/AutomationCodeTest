package util;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class Browser {

    private static WebDriver driver = null;

    public void launch() {
        openBrowser(getBrowserName());
        driver.get(getMainURL());
    }

    public void close() {
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void executeScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public static String getMainURL() {
        ReadData readData = new ReadData();
        String url = readData.getUrl();
        if (url == null) {
            throw new RuntimeException("Failed : URL cannot be empty. Please enter the URL ");
        }
        return url;
    }

    public static String getBrowserName() {
        ReadData readData = new ReadData();
        String browser = readData.getBrowser();
        if (browser == null) {
            browser = "chrome";
        }
        return browser;
    }

    /**
     * To wait for all elements to be displayed
     * @param elements
     * @param time
     */
    public void waitForElement(List<WebElement> elements, int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static String getTitle(){
        return driver.getTitle();
    }

    /**
     * Private Methods
     **/

    private void openBrowser(String browserName) {
        DesiredCapabilities capabilities;
        String driverPath = "src/main/java/drivers/";
        if(browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
            capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
            capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            driver = new InternetExplorerDriver();
        }else{
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

}
