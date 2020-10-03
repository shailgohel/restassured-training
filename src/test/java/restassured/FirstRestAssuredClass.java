package restassured;

import static org.testng.Assert.assertThrows;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonPathJsonbObjectDeserializer;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.*;

public class FirstRestAssuredClass {
	
	
	public void firstMethod() {
		
		//RestAssured request = null;
		Response response = get("https://reqres.in/api/users/2");
		System.out.println("Status code is: "+response.statusCode());

		System.out.println("Response Body is: "+response.body().toString());
		System.out.println(response.getHeader("Content-Type"));
		
	Assert.assertEquals(response.statusCode(), 201);
		
	}
	@Test
	public void secondMethod() {
		RestAssured.baseURI = "https://reqres.in/api";
		
		given()
		.queryParam("page", 2)
		.get("/users")
		.then()
		.log().ifStatusCodeIsEqualTo(201)
		.assertThat().statusCode(200)
		.body("per_page", equalTo(6))
		.body("data.first_name", hasItems("Michael"));
	}
	
	
	public void postRequest() {
		RestAssured.baseURI = "https://reqres.in/api";
		JSONObject jasonBodyObject = new JSONObject();
		jasonBodyObject.put("name", "Michae");
		jasonBodyObject.put("job", "manager");

		given()
		.body(jasonBodyObject.toJSONString())
		.post("users")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201);
	}

}

