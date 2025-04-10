package APIAutomation.RequestResponseSpecBuilder;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import APIAutomation.JSONData.PayloadJson;
import APIAutomation.JSONData.ReusableMethods;
import APIAutomation.POJOClass.Api;
import APIAutomation.POJOClass.GetCourseDetails;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderReResTest {

	public static void main(String[] args) {


//--------- Builder - Request Spec Builder ----------------------------
	 RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
	 .addQueryParam("key", "qaclick123")
	 .addHeader("Content-Type", "application/json")
	 .setContentType(ContentType.JSON)
	 .build();
	 
//--------- Builder - Response Spec Builder ----------------------------	 
	 ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200)
	 .expectContentType(ContentType.JSON)
	 .expectBody("scope", equalTo("APP"))
	 .expectHeader("server", "Apache/2.4.52 (Ubuntu)")
	 .build();
	 
	 RequestSpecification res = given().spec(req)
	 .body(PayloadJson.getAddPlaceJSON());  
	 
	 Response response = res.when().post("maps/api/place/add/json").
	 then().spec(resSpec).extract().response();
	 
	 String responseString = response.asString();
	 System.out.println("API Response: "+responseString);
	 
	 }  

}
