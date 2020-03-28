package allTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC006_GET_Request_ExtractValueOfNodeInJson {
	
	
	@Test
	void extractValueOfNodes() {
	//specifiying base URI
	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	//RequestSpecification
	RequestSpecification httpRequest=RestAssured.given();
	//obj of Response
	Response response=httpRequest.request(Method.GET, "/dhaka");
	
	//print response in console
	/*String responseBody=response.getBody().asString();
	System.out.println("ResponseBody: "+responseBody);
	*/
	//capturing json path:
	JsonPath jsonpath=response.jsonPath();
	System.out.println(jsonpath.get("City"));
	System.out.println(jsonpath.get("Temperature"));
	System.out.println(jsonpath.get("Humidity"));
	System.out.println(jsonpath.get("WeatherDescription"));
	System.out.println(jsonpath.get("WindSpeed"));
	System.out.println(jsonpath.get("WindDirectionDegree"));
	
	
	//Validate:
	Assert.assertEquals("Dhaka", jsonpath.get("City"));
	

}}
