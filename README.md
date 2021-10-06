# TestNg-Fillo-RedmineTest

# Preparation part
1) You should install GoogleChrome 93-94 version;
2) Install Java;
3) Install IntelliJ IDEA;
4) Go to pom.xml and install dependencies;
5) Edit pom.xml configuration like TestNG, Test = kind suite, Suite = path to pom.xml
6) Click to run button to run all tests;

# First test
Get all links and check status code in loop;

# Second test
Fill every visible input in the page independently and check for error message, check labels for errors. Save screenshot of each test to directory "./screenshots" where name is $inputName.

# Third test
The same as second test but fetch data from Excel file from directory "./xlsx/Test.xlsx" and put results of tests to sheet named "Result". Save screenshot to directory "./screenshots" where name is $inputName.

# Fourth test
Get data from Excel and paste to inputs then clicked submit button, check error message and save screenshot of each test to directory "./screenshots" where name is $testName + $iterator


