package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.junit.Assert;

public class restassuredBDDClass {
	
	Response res;
	
	@Given("^I am in resqres site$")
	public void i_am_in_resqres_in_site()  {
		RestAssured.baseURI = "https://reqres.in/api";
		
	}

	@When("^I use OAUth$")
	public void i_use_OAUth() {
		given().auth().oauth2("123456").queryParam("page", "2");
	    
	}
	
	@When("^execute GET method for user listing$")
	public void execute_GET_method_for_user_listing()  {
		res = when().get("/users");
		
	}

	@Then("^total should be tweleve$")
	public void total_should_be()  {
		JsonPath jsonPath = res.jsonPath();
		Assert.assertEquals(jsonPath.get("data.id[1]"), 8);
	}

	@Then("^status code should be twohudred$")
	public void status_code_should_be() {
		Assert.assertEquals(200, res.statusCode());
		
	}



}
