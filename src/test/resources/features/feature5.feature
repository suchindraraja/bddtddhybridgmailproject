Feature: Validate mail compose operation

Scenario Outline: Validate mail compose with multiple accounts
Given launch site
When enter email id as "<uid>" and click next button
And enter password as "<pwd>" and click next button
When send mail and validate the operation
|recipient										|sub		|body			|attachment																		|
|shwethapraneeth09@gmail.com	|Hi			|Shwetha	|C:\Users\gattu\Desktop\Current and future.png|
|gatturohankumar@gmail.com		|Hi			|Rohan		|C:\Users\gattu\Desktop\Current and future.png|
When do logout
When close site

Examples:
|uid													|pwd		 			|
|shwethapraneeth09@gmail.com	|pran_143			|
|priyaselenium1@gmail.com			|Selenium1!		|
|subramanyamtesting@gmail.com	|suchindra249	|