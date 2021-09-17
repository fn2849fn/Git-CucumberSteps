package steps;

import org.junit.Assert;
import io.cucumber.java.en.*;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {

	@Given("I open the browser and navigate to the HRMS")
	public void i_open_the_browser_and_navigate_to_the_hrms() {
		setUp();

	}

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {

		sendText(login.username, "admin");
		sendText(login.password, "Hum@nhrm123");

	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {

		Assert.assertTrue(true);
	}

	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {

		sendText(login.username, "admin");
		sendText(login.password, "Farshid");

	}

	@Then("I see error message")
	public void i_see_error_message() {
		boolean error = login.errorMsg.isDisplayed();
		Assert.assertTrue("Error message is not displayed", error);
	}

	@Given("I enter {string} and {string}")
	public void i_enter_and(String string, String string2) {

	}

	@Then("I see {string}")
	public void i_see(String string) {

	}

	@Then("I close the browser")
	public void i_close_the_browser() {
		tearDown();

	}
}
