package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResource;
import resources.PayLoad;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;import Pojo.JiraResponse;



public class StepDefinition extends Utils {
	RequestSpecification reqPart;
	Response response;
	JiraResponse res;
	
	@Given("Create JiraId PayLoad")
	public void create_jira_id_pay_load() throws IOException {
		reqPart=given().spec(ReqSpecificationBuild()).body(PayLoad.CreatePayLoad());
	   
	}
	@When("user calls {string} with {string} https request")
	public void user_calls_with_https_request(String resource,String Method)
	{
		APIResource ApiRes = APIResource.valueOf(resource);
		
		if (Method.equalsIgnoreCase("POST")) {
			response=reqPart.when().post(ApiRes.getApiResource()).then().extract().response();
			 res= response.as(JiraResponse.class);
		}
		else if (Method.equalsIgnoreCase("GET")) {
			//response=reqPart.when().post(ApiRes.getApiResource()).then().extract().response();
		}
		
	    
	}
	@Then("Jira id should be created")
	public void jira_id_should_be_created() {
		String jiraID = JsonPathGetValue(response, "id");
	    
	}
	@Then("Status code should be {int}")
	public void status_code_should_be(Integer statusCode) {
		
	   assertEquals(response.getStatusCode(), 201);
	}
	@Then("validate JiraId is created")
	public void validate_jira_id_is_created() {
		
	   System.out.println(res.getId());
	   System.out.println(res.getKey());
	   System.out.println(res.getSelf());
	}
	
}
