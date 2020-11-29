Feature: Validate Login operation

Scenario Outline: Validate email id field
Given launch site
When enter email id as "<uid>" and click next button
Then validate email id field with "<cr>" criteria
When close site

Examples:
|uid													|cr			|
|															|blank	|
|ssshwethapraneeth09@gmail.com|invalid|
|shwethapraneeth09@gmail.com	|valid	|

Scenario Outline: Validate password field
Given launch site
When enter email id as "shwethapraneeth09@gmail.com" and click next button
When enter password as "<pwd>" and click next button
Then validate password field with "<cr>" criteria
When close site

Examples:
|pwd				|cr			|
|						|blank	|
|pran_144		|invalid|
|pran_143		|valid	|