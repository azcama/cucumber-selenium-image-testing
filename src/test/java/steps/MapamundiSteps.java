package steps;


import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MapamundiPage;

public class MapamundiSteps {
	
	private MapamundiPage mapamundiPage = new MapamundiPage();
    
	@When("The user makes a checkpoint")
	public void the_user_makes_a_checkpoint() throws IOException {
	    mapamundiPage.doCheckpoint();
//		mapamundiPage.getImages();
//		mapamundiPage.getText();
	}
    
	@When("The user moves the mouse to {string} in the map")
	public void the_user_moves_the_mouse_to_map(String element) {
	    mapamundiPage.moveMouseToMap(element);
	}
    
	@When("The user moves the mouse to {string} in the list")
	public void the_user_moves_the_mouse_to_list(String element) {
	    mapamundiPage.moveMouseToList(element);
	}
	
	@Then("The page is different to the previous checkpoint")
	public void the_page_is_different_to_the_previous_checkpoint() throws IOException {
	    Assert.assertFalse(mapamundiPage.isEqualToPreviousStatus());
	}
	
	@Then("The page is the same to the previous checkpoint")
	public void the_page_is_the_same_to_the_previous_checkpoint() throws IOException {
	    Assert.assertTrue(mapamundiPage.isEqualToPreviousStatus());
	}
}
