package restAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPostExamples {
	
	//@Test
	void testGet() {
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().statusCode(200).
		body("data[0].first_name",equalTo("Michael")).
		body("data.first_name",hasItems("Michael","George"));
		
	}
	
	@Test
	public void testPost() {
		// I have to Create a body for Post
		//Got to Post Request
		Map<String,Object> map = new HashMap<String,Object>();
		
//		map.put("name","George");
//		map.put("job","Teacher");
//		System.out.println(map);
		
		//How to use Json library
		JSONObject request = new JSONObject();
		
		request.put("name","George");
		request.put("job","Teacher");
		
		System.out.println(request);
		
		//Just validate convert into Json format
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in/api";
		
		given().
		 header("Content-Type","application.json").
		 contentType(ContentType.JSON).
		 accept(ContentType.JSON).
		 body(request.toJSONString()).
		when().
		 post("/users").
		then().
		 statusCode(201).
		 log().all();
		
		
		
	}

}
