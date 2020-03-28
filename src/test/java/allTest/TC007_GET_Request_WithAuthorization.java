package allTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_GET_Request_WithAuthorization {
	@Test
	void getAPIWithAuthorization() {
		// base uri
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//As Authentication is needed--> we need to pass basic authentication
		PreemptiveBasicAuthScheme authscheme =new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		//now specify this authentication as RestAssured.authentication type
		RestAssured.authentication=authscheme;
		
		
		
		// Requet obj
		RequestSpecification httpRequest = RestAssured.given();
		// Response obj
		Response response = httpRequest.request(Method.GET, "/"); // we don't need to pass any parameter.. / represents  the homepage
																	

		// verify status code:
		int responseCode = response.getStatusCode();
		System.out.println("ResponseCode: " + responseCode);
		Assert.assertEquals(200, responseCode);

		// print response body
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody: "+responseBody);
	}

}
