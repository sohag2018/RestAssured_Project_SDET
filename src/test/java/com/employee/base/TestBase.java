package com.employee.base;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
public static RequestSpecification  httpRequest;
public static Response  response;
public Logger logger;
public String empID="51838";

@BeforeClass
public void setup() {
	logger=Logger.getLogger("EmployeeesRestApi");
	
}





	
	
	
}
