package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static  RequestSpecification reqspec ;
	
	//Get the global data
	
	public String gloabalData() throws IOException
	{
	
	FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"//src//test//java//resources//globalData.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String baseUri = prop.getProperty("baseURI");
	return baseUri;
	}
	
	
	public String JsonPathGetValue(Response response, String KeyValue)
	{
		String resp = response.asString();
		JsonPath js= new JsonPath(resp);
		return js.get(KeyValue).toString();
	}
	
	public static String JiraToken() {
		return "Basic cGF2YW5rdW1hcnQ4NTVAZ21haWwuY29tOkFUQVRUM3hGZkdGMHRlcHkwazAzSUVoQkd4WExKQWlLeHV3c1dTZFhMRGNkSTVZUW8zZlZEc016WTAwbk5Sal9MRTV3aWhtQkhwRHUzdVZPQmxHcThXU0NZWk9VYlo0QWdUTGlHa3hxcjQ1ZlR5ZjQxU09LbXpPZzhfMGcybTBLNFFIWHdEODdXX3JyajlNY1ZDRkh4RjRWa05vRFRZTGxzRDVOTndDMHloamF0NFFybExybkUzVT1EQzc3RkRDNQ==";
	}
	
	
	public RequestSpecification ReqSpecificationBuild() throws IOException {
		
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
		if (reqspec==null) {
			
		
		
		reqspec=  new RequestSpecBuilder().setBaseUri(gloabalData())
		.addHeader("Authorization", 		JiraToken()).setContentType(ContentType.JSON)
		.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return reqspec;
		}
		return reqspec;
	}
	
	
	
	
}
