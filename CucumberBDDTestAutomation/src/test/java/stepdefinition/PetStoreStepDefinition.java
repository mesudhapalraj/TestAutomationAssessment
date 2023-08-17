package stepdefinition;

import com.pages.PetStorepage;

import io.cucumber.java.en.*;


public class PetStoreStepDefinition {

	PetStorepage petstore = new PetStorepage();

	@Given("I Create a new user {string} {string} in Petstore {string}")
	public void i_create_a_new_user_in_petstore(String category,String firstName, String secondName) {
		petstore.postAPIResponse(category,firstName, secondName);
	}

	@Then("I get the newly created user details")
	public void i_get_the_newly_created_user_details() {
		petstore.getAPIResponse(PetStorepage.randomID);
	}

	@Then("I Delete the newly created user")
	public void i_Delete_the_newly_created_user() {
		petstore.deleteAPIResponse(PetStorepage.randomID);
	}

}
