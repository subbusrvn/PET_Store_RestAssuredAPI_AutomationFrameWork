package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviderClass;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class UserAPITest_DataDriven {
	User userpayLoad = new User();

	//@Test(priority = 1, dataProvider = "getAllData", dataProviderClass = DataProviderClass.class)
	public void testPost(String StudentID, String StudentName, String StudentLoacation, String StudentPhone) {
		
		userpayLoad.setId(StudentID);
		userpayLoad.setName(StudentName);
		userpayLoad.setLocation(StudentLoacation);
		userpayLoad.setPhone(StudentPhone);
				
		Response response = UserEndPoints.createUser(userpayLoad);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode() , 201);
		
	}
	
		
	//@Test(priority = 2)
	public void testGet() {
		Response response = UserEndPoints.getUser(this.userpayLoad.getId());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode() , 200);
		
	}
	
	
	//@Test(priority = 3, dataProvider = "getAllData", dataProviderClass = DataProvider.class)
	public void testPut(String StudentID, String StudentName, String StudentLoacation, String StudentPhone) {
		
		userpayLoad = new User();
		userpayLoad.setId(StudentID);
		userpayLoad.setName(StudentName);
		userpayLoad.setLocation(StudentLoacation);
		userpayLoad.setPhone(StudentPhone);
		
		Response response = UserEndPoints.putUser(userpayLoad, this.userpayLoad.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode() , 200);
		
		
		Response responseAfterUpdate = UserEndPoints.getUser(this.userpayLoad.getId());
		responseAfterUpdate.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode() , 200);
		
	}
	
	
	
	@Test(priority = 4, dataProvider = "getStudentID", dataProviderClass= DataProviderClass.class)
	public void testDelete(String StudentID) {
		userpayLoad.getId();
		
		
		Response response = UserEndPoints.deleteUser(StudentID);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode() , 200);
		//response.getBody().asString();
		System.out.println(response);
		
	}

}

