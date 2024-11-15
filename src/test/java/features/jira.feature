Feature: to validate Jira id is created when the user loggs a defect

Scenario: Verify JiraId is create 

Given Create JiraId PayLoad
When user calls "CreateJiraIssue" with "Post" https request
Then Jira id should be created
And Status code should be 201
And validate JiraId is created
