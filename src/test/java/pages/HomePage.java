package pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import database.SeleniumDatabase;
import webbrowser.WebDriverFactory;

public class HomePage {

	static private WebDriver driver;

	private String url = "https://url.to.test/";

	private By logoutByXpath = By.xpath("//td[text()='Logout']");
	private By usernameByID = By.id("username");
	private By passwordByID = By.id("password");
	private By loginButtonByID = By.id("loginViewButArea");
	
	private String USERNAME = "userToAnonymize";
	private String PASSWORD = "passToAnonymize";

	private SeleniumDatabase dbTest = new SeleniumDatabase();
	private List<Integer> elementsToRemove = new ArrayList<Integer>();

	protected static WebDriver getDriver() {
		return driver;
	}

	private static void setDriver(WebDriver driver) {
		HomePage.driver = driver;
	}
	
	private void startDrivers() {
		setDriver(WebDriverFactory.createWebDriver());

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
	}

	public void goToHome() {
		startDrivers();
		getDriver().get(url);
	}

	public void login() {
		getDriver().findElement(usernameByID).sendKeys(USERNAME);
		getDriver().findElement(passwordByID).sendKeys(PASSWORD);
		getDriver().findElement(loginButtonByID).click();
	}

	public void addElementToRemove(int elementToRemove) {
		elementsToRemove.add(elementToRemove);
	}

	public ResultSet search_in_database(String search) {
		try {
			dbTest.setUp();
			return dbTest.doQuery(search);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public void close() {
		closeSession();
		dbTest.close();
		getDriver().quit();
	}

	private void closeSession() {
	    getDriver().findElement(logoutByXpath).click();
	    driver.switchTo().alert().accept();
	}

}
