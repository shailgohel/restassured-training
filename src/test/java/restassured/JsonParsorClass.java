package restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonParsorClass {
	@Test
	public void secondMethod() {
		RestAssured.baseURI = "https://reqres.in/api";
		
		Response response = given()
		.queryParam("page", 2)
		.get("/users")
		;
		System.out.println(response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		JsonPath jsonPath = response.jsonPath();
		System.out.println(jsonPath.get("data.id[1]"));
		Assert.assertEquals(jsonPath.get("data.id[1]"), 8);
		Assert.assertEquals(jsonPath.getBoolean("data.findAll{id < 8}.first_name"), "Lindsay");
	}

}
