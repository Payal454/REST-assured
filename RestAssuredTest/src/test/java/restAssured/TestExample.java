package restAssured;

import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestExample {


	@Test
	void Test_1() {

		Response response =  get("https://reqres.in/api/users?page=2");
		System.out.println(	response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getTime());
		System.out.println(response.getHeader("Content-Type"));
		
		int statuscode =response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		System.out.println(statuscode);	
		
	}
	@Test
	void Test_2() {
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().statusCode(200).
		body("data[1].id",equalTo(8)).
		log().all();
		
	}

}
