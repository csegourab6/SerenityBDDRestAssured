Feature: EPL Clubs 

@Smoke
Scenario: EPL Clubs Basic Test
When user sends a request to epl clubs endpoint status code 200 is returned


@Regression @Positive
Scenario: EPL Clubs CREATE Test
When user sends create club request 201 status code is returned
Then user sends get club request the created club is returned

Scenario: EPL Clubs DELETE Test
Given user has created a club
When user deletes the club by id then 200 is returned
Then user sends a get club request by id empty body returned

@Regression @Negetive
Scenario: EPL Clubs DELETE Negetive Test
When user deletes an ivalid club 404 is returned


