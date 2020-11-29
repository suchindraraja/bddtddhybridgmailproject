Feature: Validate mail compose operation

Scenario: Validate mail compose
Given launch site
When enter email id as "shwethapraneeth09@gmail.com" and click next button
And enter password as "pran_143" and click next button
When send mail and validate the operation
|recipient										|sub		|body			|
|shwethapraneeth09@gmail.com	|Hi			|Shwetha	|
|gatturohankumar@gmail.com		|Hi			|Rohan		|
|priyahyd528@gmail.com				|Hi			|Priya		|
|farheensult@gmail.com				|Hi			|Farheen	|
|vrajashekar35@gmail.com			|Hi			|Raj			|
|suchindra249@gmail.com				|Hi			|Suchi		|
|riyaz.selenium@gmail.com			|Hi			|Riyaz		|
|anushauks@gmail.com					|Hi			|Anusha		|
|gchandrakala12@gmail.com			|Hi			|Chandu		|
|venu.srivenu@gmail.com				|Hi			|Venu			|
When close site