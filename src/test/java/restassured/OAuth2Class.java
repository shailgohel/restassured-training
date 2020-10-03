package restassured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.ImplMethodData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.pattern.PropertiesPatternConverter;

import static io.restassured.RestAssured.*;

public class OAuth2Class extends ImplMethodData {
	Logger logger = Logger.getLogger(OAuth2Class.class);

	
	@BeforeClass
	public void setupMethod() {
		
		PropertyConfigurator.configure("log4j.properties");

		RestAssured.baseURI = "http://coop.apps.symfonycasts.com/token";
		

		Response res = given().formParam("client_id", "SimplyLearnTraining")
				.formParam("client_secret", "b15caae131be71615d45c0f712d95cfd")
				.formParam("grant_type", "client_credentials").formParam("scope", "chickens-feed")
				.formParam("scope", "eggs-collect").when().post();
		logger.info("Access Token is: "+res.getBody().jsonPath().get("access_token").toString());
		setAccessToken(res.getBody().jsonPath().get("access_token").toString());

		setBaseURI("http://coop.apps.symfonycasts.com/api");
		
		logger.info("Base URL is: "+getBaseURI());
		
		// setAccessToken("23722246af3dc2a9498e17b2d4593b1be3f557be");
		setUserId("/1407");
		setMethodPath("/eggs-collect");
		
		logger.info("userId is: "+getUserId());
		
	}

	@Test
	public void testSsl() {
		Response res = given().relaxedHTTPSValidation().when().get("http://www.bupa.com.au/");
		if(res.statusCode() == 201) {
			logger.info(res.statusCode()+" is ok");
		}
		else {
			logger.error("Wrong Status code: "+res.statusCode());
		}
		
		try {
			FileInputStream fis = new FileInputStream(new File("test.xml"));
		} catch (FileNotFoundException e) {
			logger.error(e);
		}
	}

	@Test
	public void oAuth2Method() {
		given().auth().oauth2(getAccessToken()).when().post(getUserId() + getMethodPath()).then()
				.assertThat().statusCode(200).body("action", equalTo("eggs-collect"));
	}
}
