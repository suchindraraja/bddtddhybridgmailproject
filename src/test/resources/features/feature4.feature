Feature: Validate mail compose operation

Scenario: Validate mail compose
Given launch site
When enter email id as "shwethapraneeth09@gmail.com" and click next button
And enter password as "pran_143" and click next button
When send mail and validate the operation
|recipient										|sub		|body			|attachment																		|
|shwethapraneeth09@gmail.com	|Hi			|Shwetha	|C:\Users\gattu\Desktop\Current and future.png|
|gatturohankumar@gmail.com		|Hi			|Rohan		|C:\Users\gattu\Desktop\Current and future.png|
|priyahyd528@gmail.com				|Hi			|Priya		|C:\Users\gattu\Desktop\Current and future.png|
|farheensult@gmail.com				|Hi			|Farheen	|C:\Users\gattu\Desktop\Current and future.png|
|vrajashekar35@gmail.com			|Hi			|Raj			|C:\Users\gattu\Desktop\Current and future.png|
|suchindra249@gmail.com				|Hi			|Suchi		|C:\Users\gattu\Desktop\Current and future.png|
|riyaz.selenium@gmail.com			|Hi			|Riyaz		|C:\Users\gattu\Desktop\Current and future.png|
|anushauks@gmail.com					|Hi			|Anusha		|C:\Users\gattu\Desktop\Current and future.png|
|gchandrakala12@gmail.com			|Hi			|Chandu		|C:\Users\gattu\Desktop\Current and future.png|
|venu.srivenu@gmail.com				|Hi			|Venu			|C:\Users\gattu\Desktop\Current and future.png|
|nuka.geeta@gmail.com					|Hi			|Geeta		|C:\Users\gattu\Desktop\Current and future.png|
|satheeshreddy9494@gmail.com	|Hi			|Satheesh	|C:\Users\gattu\Desktop\Current and future.png|
|himajasap@gmail.com					|Hi			|Himaja		|C:\Users\gattu\Desktop\Current and future.png|
|qavinnu@gmail.com						|Hi			|Vinod		|C:\Users\gattu\Desktop\Current and future.png|
When do logout
When close site