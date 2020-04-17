package newtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGET {

	// REST API token from website
	private static String token = "OCQMCeo7C4zjbd0suKhNtgOpBv3Dx9AHbiWH";

	@Test
	void test() {

		// Setting BaseURI
		RestAssured.baseURI = "https://gorest.co.in/public-api/users";
		// Define the specification of request
		RequestSpecification rsp = RestAssured.given();
		// REST API response with oauth2 (token) to make an HTML Call
		Response response = rsp.auth().oauth2(token).when().get(RestAssured.baseURI);

		// response body to string
		String respo = response.getBody().asString();

		// JsonPath parsing library to Parse the JSON
		JsonPath jsonp = new JsonPath(respo);
		// print fristname from the string
		System.out.println("First Name is : " + jsonp.getString("result[0].first_name"));

		Assert.assertEquals(jsonp.getString("result[0].first_name"), "Lucas");

	}

}
