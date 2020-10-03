package restassured;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuthentication {
	
	@Test
	public void basicAuthenticatinMethod() {
		RestAssured.baseURI = "https://github.com/shailgohel";
		
		given()
			.auth()
			.basic("shaigohel", "TetGithub@123")
			.when()
				.get()
				.then()
				.log().all();
				
		
		
		
	}
}
