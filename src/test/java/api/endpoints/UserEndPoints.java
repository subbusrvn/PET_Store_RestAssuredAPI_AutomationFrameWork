package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.apache.commons.compress.compressors.pack200.Pack200CompressorOutputStream;

import api.payload.User;
import io.restassured.http.ContentType;

//Create to perform the CRD operation of the apis.
public class UserEndPoints {

	//Method Created for Creating the User
	public static Response createUser(User Payload) {
		Response response = 
				given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)
				.when()
				.post(Routes.createUrl);

		return response;

	}
	
	//Method created to Get the User
		public static Response getUser(String userId) {
			Response response = 
					given()
					.pathParam("user_id", userId)
					.when()
					.get(Routes.getUrl);

			return response;
		}

		public static Response putUser(User Payload, String userId) {
			Response response = 
					given()
					.pathParam("user_id", userId)
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(Payload)
					.when()
					.put(Routes.putUrl);

			return response;

		}
		

		
		public static Response deleteUser(String userId) {
			Response response = 
					given()
					.pathParam("user_id", userId)
					.when()
					.put(Routes.deleteUrl);

			return response;

		}
	
}