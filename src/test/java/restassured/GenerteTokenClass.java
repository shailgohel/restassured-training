package restassured;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import Util.ImplMethodData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GenerteTokenClass extends ImplMethodData{
	@Test
	public void generateTokenmethod() {
		
		RestAssured.baseURI = "http://coop.apps.symfonycasts.com/token";
		
		Response res = given()
		.formParam("client_id", "SimplyLearnTraining")
		.formParam("client_secret", "b15caae131be71615d45c0f712d95cfd")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "chickens-feed")
		.when()
		.post()
		;
		
		setAccessToken(res.getBody().jsonPath().get("access_token").toString());
		
		
		
	}

}
