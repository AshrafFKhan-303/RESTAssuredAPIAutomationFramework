package APIAutomation.JSONData;

import io.restassured.path.json.JsonPath;

public class ReusableMethods{

	public static JsonPath rowToJson(String responce) {
		
		JsonPath getRes = new JsonPath(responce);
		return getRes;
	}
	
}
