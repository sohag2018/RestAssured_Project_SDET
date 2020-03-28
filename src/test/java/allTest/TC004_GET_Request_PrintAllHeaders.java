package allTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request_PrintAllHeaders {
	
	@Test
	void printAllHeaders() {
		//specify base URI
		RestAssured.baseURI="https://maps.googleapis.com";
		//obj of RequestSpecification
		RequestSpecification httpRequest=RestAssured.given();
		//obj of Response after defining the request 
	    Response response=httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
	    
	    //print responseBody in console
	   String responseBody= response.getBody().asString();
	   System.out.println("Response Body: "+responseBody);
	   
	 //print all header info in console
	   Headers allHeader =response.headers();
	   for(Header header:allHeader) {
		   System.out.println(header.getName()+" :"+header.getValue());
	   }
	}

}
