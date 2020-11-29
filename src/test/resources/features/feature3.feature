Feature: Validate Logout operation

Scenario: Validate logout
Given launch site
When enter email id as "shwethapraneeth09@gmail.com" and click next button
And enter password as "pran_143" and click next button
When do logout and validate logout
When close site