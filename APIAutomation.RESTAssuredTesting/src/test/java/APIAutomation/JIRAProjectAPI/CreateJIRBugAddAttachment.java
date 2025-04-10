package APIAutomation.JIRAProjectAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import APIAutomation.JSONData.ReusableMethods;


class CreateJIRBugAddAttachment {

	public static void main(String[] args) {

//------- Created Bug -----------------		
	 RestAssured.baseURI="https://ashrafkhan78625.atlassian.net/";
	 String bugResPOST = given()
	 .header("Content-Type", "application/json")
	 .header("Authorization", "Basic YXNocmFma2hhbjc4NjI1QHlhaG9vLmNvbTpBVEFUVDN4RmZHRjBwQWRwQm5meWx0bXhyMU9HS00yb2s0eWtLUHpUSTZSM3VFUGVrSFFuc1l3NW5XbFRENEdNci1IUUpWOUlweDlSVkZuemdzUkJaZ0ptS1hHWUxYRGpxa0VweEtMV05Jc01sb1h2NHptR0dQQjdkZGZnMG9sci1mVWpRZEY1MDlaRFEzMFhLQnlnZHVGbVF5RDRkMTJOSm82YVB0OGZ1NWhFR1FfNHI2dWRlREE9NzRBNjA5REQ=")
	 .body("{\n" + 
	 		"    \"fields\": {\n" + 
	 		"       \"project\":\n" + 
	 		"       {\n" + 
	 		"          \"key\": \"SCRUM\"\n" + 
	 		"       },\n" + 
	 		"       \"summary\": \"Website Link not working\",\n" +  
	 		"       \"issuetype\": {\n" + 
	 		"          \"name\": \"Bug\"\n" + 
	 		"       }\n" + 
	 		"   }\n" + 
	 		"}\n" + 
	 		"")
	 		.log().all()
	 		.post("rest/api/3/issue").
	 		then().log().all().assertThat().statusCode(201)
	 		.extract().response().asString();
		
	 		JsonPath jp	= ReusableMethods.rowToJson(bugResPOST);
	 		String bugId = jp.getString("id");
	
	 		System.out.println("bugId: "+bugId);
	
//Attach file in created bud - issue
	 		given()
	 		//.header("Content-Type", "application/json")
	 		.header("X-Atlassian-Token", "no-check").pathParam("key", bugId)
	 		.header("Authorization", "Basic YXNocmFma2hhbjc4NjI1QHlhaG9vLmNvbTpBVEFUVDN4RmZHRjBwQWRwQm5meWx0bXhyMU9HS00yb2s0eWtLUHpUSTZSM3VFUGVrSFFuc1l3NW5XbFRENEdNci1IUUpWOUlweDlSVkZuemdzUkJaZ0ptS1hHWUxYRGpxa0VweEtMV05Jc01sb1h2NHptR0dQQjdkZGZnMG9sci1mVWpRZEY1MDlaRFEzMFhLQnlnZHVGbVF5RDRkMTJOSm82YVB0OGZ1NWhFR1FfNHI2dWRlREE9NzRBNjA5REQ=")
	 		.multiPart("file", new File("C:\\Users\\Am\\Desktop\\Resume.jpg")).log().all()
	 		.post("rest/api/3/issue/{key}/attachments").
	 		then().log().all().assertThat().statusCode(200);
	 		
	}

}
