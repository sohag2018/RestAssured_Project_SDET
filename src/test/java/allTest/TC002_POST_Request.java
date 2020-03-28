package allTest;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	
	
	
	@Test
	void newCustomerRegistration() {
		HashMap<String, String>map=new HashMap<String, String>();
		map.put("FirstName", "abc");
		map.put("LastName", "kkk");
		map.put("UserName", "dffdf");
		map.put("Password", "Pass_123dffff45");
		map.put("Email", "jfjdfjl@gamil.com");
		//specify base URI:
				RestAssured.baseURI="http://restapi.demoqa.com/customer";
				//request obj
				RequestSpecification httpRequest=RestAssured.given();
				
				//request Payload:
				JSONObject requestParams=new JSONObject(map);
//				requestParams.put("FirstName", "Muhammad");
//				requestParams.put("LastName", "Sohag");
//				requestParams.put("UserName", "M_sohag");
//				requestParams.put("Password", "Pass_123");
//				requestParams.put("Email", "soh@gamil.com");
				//defining header and body
				httpRequest.header("Content-Type","application/json");
				httpRequest.body(requestParams.toJSONString());
				
				//respnse obj:
				Response response=httpRequest.request(Method.POST, "/register");
				
				//print response in console just to see
				String responseBody=response.getBody().asString();
				System.out.println("ResponseBody: "+responseBody);
				
				//status code validation:
				int respnseCode=response.getStatusCode();
				System.out.println("ResponseCode: "+respnseCode);
				Assert.assertEquals(respnseCode, 201);
				
				//success code validation:
				String SuccessCode=response.jsonPath().get("SuccessCode");
				System.out.println("success code: "+SuccessCode);
				Assert.assertEquals(SuccessCode, "OPERATION_SUCCESS");
	}

}
