package webbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver createWebDriver() {
        String webdriver = System.getProperty("browser", "firefox");
        switch(webdriver) {
            case "firefox":
            	System.setProperty("webdriver.gecko.driver","/usr/local/Cellar/geckodriver/0.27.0/bin/geckodriver");
                return new FirefoxDriver();
            case "chrome":
            	System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            	return new ChromeDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }
}