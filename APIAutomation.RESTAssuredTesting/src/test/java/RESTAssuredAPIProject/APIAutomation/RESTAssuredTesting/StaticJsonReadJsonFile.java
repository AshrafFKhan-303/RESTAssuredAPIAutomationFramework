 package RESTAssuredAPIProject.APIAutomation.RESTAssuredTesting;

//package RESTAssuredAPIProject.APIAutomation.RESTAssuredTesting.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import APIAutomation.JSONData.PayloadJson;
import APIAutomation.JSONData.ReusableMethods;


public class StaticJsonReadJsonFile {

  public static void main(String[] args) throws IOException {
			
		//Validate if Add Place API is working s expected	
		//given - All input details
		//when - Submit the API
		//then - Validate the API response	
			
//Add Place -> Update Place with the new Address -> Get place to validate if now address is present in response
			
//POST Method --------- POST Add Place API		
//Content of the file to String->content of file can convert into Byte data to String 	
	  
	  	RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		
	//--- Read pyload from json file	
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users.....ddPlce.json")))).
		when().post("maps/api/place/add/json").
		then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println("API Response: "+response);
		
	//Defined Custom Class and Reusble methods   
		 JsonPath getRes = ReusableMethods.rowToJson(response);
		 String placeId = getRes.getString("place_id");
		  
		
	//Parse json API response --------------------
//		JsonPath jp = new JsonPath(response);
//		String placeId = jp.getString("place_id");

		System.out.println("placeId: "+placeId);
		

	}

}
