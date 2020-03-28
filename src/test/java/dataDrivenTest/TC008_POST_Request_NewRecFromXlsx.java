package dataDrivenTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC008_POST_Request_NewRecFromXlsx {
	
	@Test(dataProvider="assistant")
	void createNewRecord(String name,String sal,String age) {
	//specifying the base URI & requestSpecification by using RestAssured:
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	RequestSpecification httpRequest=RestAssured.given();
	
	//creating payload for the body-->we could create by using HashMap too in that case-->JSONObject requestPram=new JSONObject(obj of hashMap);
	JSONObject requestPram=new JSONObject();
	requestPram.put("name", name);
	requestPram.put("salary", sal);
	requestPram.put("age", age);
	
	
	//getting ready with header and body
	httpRequest.header("Content-Type","application/json;charset=utf-8");
	httpRequest.body(requestPram.toJSONString());
	//Send the requst
	Response response=httpRequest.request(Method.POST, "/create");
	//Getting Response:
	String respnseBody=response.getBody().asString();
	//print body:
	System.out.println("ResponseBodty: "+respnseBody);
	
	//validate:
	Assert.assertEquals(respnseBody.contains(name),true);
	Assert.assertEquals(respnseBody.contains(sal),true);
	Assert.assertEquals(respnseBody.contains(age),true);
	
	int statusCode=response.getStatusCode();
	Assert.assertEquals(200, statusCode);
	
	}
	
	
	@DataProvider(name="assistant")
	public String [][] getemployeeData() throws IOException{
		String path=System.getProperty("user.dir")+"/EmplyeeRegi.xlsx";
		int rowNum=XLUtil.getRowCount(path, "NewEmplyee");
		int columnCount=XLUtil.getCellCount(path, "NewEmplyee", 1);
		
		
		
		//declaring 2D array
		String[][] empData=new String[rowNum][columnCount];
		//read data using nested for loop
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<columnCount;j++) {
				empData[i-1][j]=XLUtil.getCellData(path, "NewEmplyee", i, j);
			}
		}
		
		
		
		//String[][] empData= {{"Sharif","123","40"},{"Sohag","545","41"},{"Monir","552","42"}};
		return empData;
		
	}

}
