Narrative:
This story cover basic tests of signup

Scenario: Validate existing email error
Given user opens signup page
When user clicks on "connect" button
And user clicks on "new account" button
And user type "Alex" first name
And user type "Ciobanu" last name
And user type "caldare_alex@mail.ru" email
And user type "123tarakan" password
And user type "123tarakan" confim password
And user scroll down "1" times
And user set "SMS" communication way
And user set "E-mail personalizat" communication way
And user set the check box
And user should wait "2" seconds
Then user should see the error "Un utilizator cu adresa de e-mail există deja. Vă rugăm să verificați informațiile cu exactitate sau introduceți o altă adresă de e-mail."

Scenario: Validate empty first name error
Given user opens signup page
When user clicks on "connect" button
And user clicks on "new account" button
And user type "Ciobanu" last name
And user type "caldare_test@mail.ru" email
And user type "123tarakan" password
And user type "123tarakan" confim password
And user scroll down "1" times
And user set "SMS" communication way
And user set "E-mail personalizat" communication way
And user set the check box
And user should wait "2" seconds
And user scroll up "1" times
Then user should see the error "Vă rugăm să introduceți un prenume"

Scenario: Validate empty password error
Given user opens signup page
When user clicks on "connect" button
And user clicks on "new account" button
And user type "Alex" first name
And user type "Ciobanu" last name
And user type "caldare_test@mail.ru" email
And user scroll down "1" times
And user set "SMS" communication way
And user set "E-mail personalizat" communication way
And user set the check box
And user should wait "2" seconds
Then user should see the error "Vă rugăm să introduceți o parolă validă."
Then user should see the error "Vă rugăm să introduceți o parolă valabilă Confirmați."