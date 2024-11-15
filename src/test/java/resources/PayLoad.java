package resources;

import Pojo.Body;
import Pojo.Project;
import Pojo.fileds;
import Pojo.issuetype;

public class PayLoad {
	
	public static Body CreatePayLoad() {
		
	
	Body payLoadBody= new Body();
	fileds field= new fileds();
	Project po= new Project();
	issuetype issue= new issuetype();
	
	po.setKey("SCRUM1");
	issue.setName("Bug");

	field.setIssuetype(issue);
	field.setProject(po);
	field.setSummary("Test Area is not Interacting");
	
	payLoadBody.setFields(field);
	return payLoadBody;
	
	}
}
