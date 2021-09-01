package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import pages.HomePage;

public class HomeSteps {
	protected HomePage homePage = new HomePage();
	
	@Given("The Porsche home page")
    public void create_Browser() {
		homePage.goToHome();
    }
	
	@Given("The user logins into the site")
	public void the_user_logins_into_the_site() {
	    homePage.login();
	}
	  
	@After
	public void after(Scenario scenario) {
    	homePage.close();
	}

}
