Feature: Log in to the Gmail application


#Background:
#		
#Given The user users "browser" browser to log in to "url" 


Scenario Outline: Test the login functionality of gmail
Given The user users '<browser>' browser to log in to '<url>'
#Given The user users is in gmail page
When The user try to enter "usr_id" and "password"
And User try to log in the  his gmail id
Then The user should be able to log in to the web page

Examples:
|browser||url||usr_id||password|
|"chrome"||"https://mail.google.com/mail/u/0/#inbox"||"sumith.pa@gmail.com"||"ajithsumith231192"|
