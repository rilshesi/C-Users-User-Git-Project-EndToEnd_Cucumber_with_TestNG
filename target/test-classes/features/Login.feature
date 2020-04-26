Feature: Login into applicatrion

	Scenario Outline: positive test validating login1
		Given Initialize browser from base file and navigate to url
		And Verify page centre tittle is displayed and get failure screen shot
		And Click on signin to get to login page
		When User enter "<username>" and "<password>" to login
		Then Validate that user is successfully logged in
		And Close browser
		
		
	Examples:
	|username					|password			|
	|olushesi@yahoo.com			|Rodmanraylex1		|
	|olushesi@yahoo.com			|Rodmanraylex1		|
		
	
		
		
	