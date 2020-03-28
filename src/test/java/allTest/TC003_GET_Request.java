package allTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
	
	@Test
	void googleMapTest() {
		//specify base URI:
		RestAssured.baseURI="https://maps.googleapis.com";
		//Request obj:
		RequestSpecification httpRequest=RestAssured.given();
		//response obj
		Response response =httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
	    //print response in console:
		String responseBody=response.getBody().asString();
		System.out.println("ResponseBody: "+responseBody);
		
		//capture details from response header:
		//containt Type
		String contentType=response.header("Content-Type");
		System.out.println("Content-Type: "+contentType);
		Assert.assertEquals(contentType, "application/xml;charset=UTF-8");
	    //content encoding
		String contentEncoding=response.header("Content-Encoding");
		System.out.println("Content-Encoding : "+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}
	

}
