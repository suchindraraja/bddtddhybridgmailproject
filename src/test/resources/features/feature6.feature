Feature: Validate mail compose operation

Scenario: Validate mail compose
Given launch site
When enter email id as "shwethapraneeth09@gmail.com" and click next button
And enter password as "pran_143" and click next button
When send mail by taking data from excel and validate the operation
When do logout
When close site