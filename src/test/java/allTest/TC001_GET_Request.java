package allTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class TC001_GET_Request {
	
	@Test
	public void getWeatherDetails() {
		//specify base URI:
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		//request obj
		RequestSpecification httpRequest=RestAssured.given();
		//response obj:
		Response response=httpRequest.request(Method.GET, "/dhaka");
		//print response in console just to see
		String responseBody=response.getBody().asString();
		System.out.println("ResponseBody: "+responseBody);
		
		//status code validation:
		int respnseCode=response.getStatusCode();
		System.out.println("ResponseCode: "+respnseCode);
		Assert.assertEquals(respnseCode, 200);
		
		//status line validation
		String statusLine=response.statusLine();
		System.out.println("ResponseLine: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
