package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalApi {
	
	//@Test
	public void get() {
		
		baseURI="http://localhost:3000/";
		given().get("/users").then().statusCode(200).log().all();	
	}
	
	//@Test
	public void post() {
		
		
		JSONObject request = new JSONObject();
		
		request.put("firstname","Thomas");
		request.put("lastname","Edison");
		request.put("subjectid",1);
		baseURI="http://localhost:3000/";
		
		given().contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201); //Success Create
		
	}
	
	//@Test
	public void put() { // for need to update
		
		
		JSONObject request = new JSONObject();
		
		request.put("firstname","Albert");
		request.put("lastname","Einstain");
		request.put("subjectid",2);
		baseURI="http://localhost:3000/";
		
		given().contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/4"). // 
		then().
		statusCode(200); //Success Create
		
	}
	
	//@Test
	public void patch() { // for need to update
		
		
		JSONObject request = new JSONObject();
		
		request.put("lastname","Deo");
		baseURI="http://localhost:3000/";
		
		given().contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/4"). // 
		then().
		statusCode(200); //Success Create
		
	}
	@Test
	public void delete() {
		
		baseURI="http://localhost:3000/";
		
		when().delete("/users/5").then().statusCode(200);
		
	}
	
	

}
