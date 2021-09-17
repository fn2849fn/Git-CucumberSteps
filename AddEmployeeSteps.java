package steps;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utils.CommonMethods;
import utils.ConfigsReader;

public class AddEmployeeSteps extends CommonMethods {

	String empId;

	@Given("I am logged into HRMS")
	public void i_am_logged_into_hrms() {

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

	}

	@Given("I navigate to Add Employee page")
	public void i_navigate_to_add_employee_page() {

		dashboard.navigateToAddEmployee();
	}

	@When("^I add \"([^\"]*)\",\"([^\"]*)\", and \"([^\"]*)\"$")
	public void i_add_and(String fName, String mName, String lName) {

		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		empId = addEmp.empId.getText();
	}

	@When("I click on the Save")
	public void i_click_on_the_save() {
		click(addEmp.saveBtn);
	}

	@Then("I see the employee has been successfully added")
	public void i_see_the_employee_has_been_successfully_added() {

		Assert.assertEquals("Employee is Not being added", pdetails.empId.getText(), empId);

	}

	@Then("^I see the employee with \"([^\"]*)\",\"([^\"]*)\", and \"([^\"]*)\" is displayed$")
	public void i_see_the_employee_with_and_is_displayed(String arg1, String arg2, String arg3) {

	}

	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {

		List<Map<String, String>> empDetailList = empDetails.asMaps();

		for (Map<String, String> map : empDetailList) {
			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));
		}
	}

	@When("I click on the Edit")
	public void clickOnEdit_SaveButton() {
		click(pdetails.edit_SaveBtn);
	}

	@Then("I am able to modify Employee Details")
	public void modifyEmployeeDetails(DataTable modifyEmpDetail) throws InterruptedException {
		List<Map<String, String>> modifyList = modifyEmpDetail.asMaps();

		for (Map<String, String> map : modifyList) {
			// click on Edit

			click(pdetails.edit_SaveBtn);

			// Passing new details to the employee
			sendText(pdetails.licenNo, map.get("DriverLisence"));
			Thread.sleep(1000);
			sendText(pdetails.licExpDate, map.get("ExpirationDate"));
			Thread.sleep(1000);
			clickRadio(pdetails.genderLabels, map.get("Gender"));
			Thread.sleep(1000);
			selectDdValue(pdetails.maritalStatus, map.get("MaritalStatus"));
			Thread.sleep(2000);
			selectDdValue(pdetails.nationality, map.get("Nationality"));
			Thread.sleep(1000);
			sendText(pdetails.dateOfBirth, map.get("DOB"));
			Thread.sleep(1000);
			// clixk on Save
			click(pdetails.edit_SaveBtn);
		}
	}

}
