package RESTAssuredAPIProject.APIAutomation.RESTAssuredTesting;

import org.testng.Assert;

import APIAutomation.JSONData.PayloadJson;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		
//Mocking API Json respomse by proving hard Json vlaue in custom class		
		
	JsonPath jp = new JsonPath(PayloadJson.CoursePrice());
	
//1. Print No of courses returned by API
	 int courseCount = jp.getInt("courses.size()");
	 System.out.println("No of Courses: "+ courseCount);

//2.Print Purchase Amount	 
	int purchaseAmt = jp.getInt("dashboard.purchaseAmount"); 
	System.out.println("purchaseAmt: "+ purchaseAmt);
	
//3. Print Title of the first course	
	 String firstcourse = jp.getString("courses[0].title");
	 System.out.println("firstcourse: "+ firstcourse);

//4. Print All course titles and their respective Prices	
	for(int i=0;i<courseCount;i++) {
		System.out.println(jp.getString("courses["+i+"].title".toString()));
		System.out.println(jp.getString("courses["+i+"].price".toString()));
	}
	
//6. Verify if Sum of all Course prices matches with Purchase Amount
	int totalPrice = 0;
	for(int i=0;i<courseCount;i++) {
			
		int price = jp.getInt("courses["+i+"].price"); 
		int noOfCopies = jp.getInt("courses["+i+"].copies"); 
		int sum = price*noOfCopies; 
		totalPrice = totalPrice+sum;
	}
	
	int actualPrice = jp.getInt("dashboard.purchaseAmount");
	System.out.println("actualPrice: "+actualPrice);
	System.out.println("totalPrice"+totalPrice);
	Assert.assertEquals(actualPrice, totalPrice);
	
	}





 

//
//	5. Print no of copies sold by RPA Course
//
//	6. Verify if Sum of all Course prices matches with Purchase Amount
	
	
}  
