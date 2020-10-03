package restassured;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class XMLClass {
	public void xmlMEthod() {
		RestAssured.baseURI = "";
		
		given()
		.contentType(ContentType.XML).accept(ContentType.XML)
		.body("<empName>Lavanya Gowda</empName>\" + \"<empAddress>abc</empAddress>\"\n" + 
				"				+ \"<mobileNumber>1592211560</mobileNumber>\" + \"<department>abc</department>\" + \"<project>abc</project>\"\n" + 
				"				+ \"<teamLead>abc</teamLead>\" + \"<salary>10000</salary>\" + \"<joiningDate>11-10-19</joiningDate>\"\n" + 
				"				+ \"</Employee>")
			.when()
				.get()
					.then()
					.log().all();
		
	}
}
