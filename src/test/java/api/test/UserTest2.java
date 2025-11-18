package api.test;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {
	User userpayLoad;
	Faker fake;
	public Logger logger;
	
	@BeforeClass
	void setData(){
		userpayLoad = new User();
		fake = new Faker();
		
		userpayLoad.setId(fake.name().toString());
		userpayLoad.setName(fake.name().toString());
		userpayLoad.setLocation(fake.name().toString());
		userpayLoad.setPhone(fake.phoneNumber().toString());
		logger= (Logger) LogManager.getLogManager();
		
	}
	
	@Test(priority = 1)
	public void testPost() {
		Response response = UserEndPoints.createUser(userpayLoad);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode() , 201);
		
	}
	
	
	
	@Test(priority = 2)
	public void testGet() {
		Response response = UserEndPoints.getUser(this.userpayLoad.getId());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode() , 200);
		
	}
	
	
	@Test(priority = 3)
	public void testPut() {
		userpayLoad.setId(fake.name().toString());
		userpayLoad.setName(fake.name().toString());
		userpayLoad.setLocation(fake.name().toString());
		userpayLoad.setPhone(fake.phoneNumber().toString());
		
		Response response = UserEndPoints.putUser(userpayLoad, this.userpayLoad.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode() , 200);
		
		
		Response responseAfterUpdate = UserEndPoints.getUser(this.userpayLoad.getId());
		responseAfterUpdate.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode() , 200);
		
	}
	
	
	//@Test(priority = 4)
	public void testDelete() {
		
		Response response = UserEndPoints.deleteUser(this.userpayLoad.getId());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode() , 200);
		
	}

}

