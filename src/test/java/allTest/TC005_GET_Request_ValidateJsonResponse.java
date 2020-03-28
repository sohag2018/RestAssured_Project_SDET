package allTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_GET_Request_ValidateJsonResponse {
	@Test
	void validateJsonResponse() {
		//specifying the baseURI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		//obj of RequestSpecification
		RequestSpecification httpRequest=RestAssured.given();
		//obj of Response
		Response respnose=httpRequest.request(Method.GET, "/dhaka");
		//Print responsebody
		String responseBody=respnose.getBody().asString();
		System.out.println("ResponseBody: "+responseBody);
		
		//Verifying:
		Assert.assertEquals(responseBody.contains("Dhaka"), true);
		
	}

}
