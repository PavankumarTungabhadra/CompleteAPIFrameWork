package resources;

public enum APIResource {

	
	CreateJiraIssue("rest/api/3/issue"),
	GeatJiraIssue("rest/api/3/issue");
	
	private String resource;
	APIResource(String resource) {
		this.resource=resource;
		
	}
	
	public String getApiResource()
	{
		return resource;
	}
	
	
}

