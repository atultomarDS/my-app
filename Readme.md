TEST INSTRUCTIONS:

- Clone the app code(my-app).
- Import the Project into any IDE(eclipse/Intellij).
- Open pom.xml file and download the maven dependency and build the project. 

Directories Definition: 

src/main/java/helpers:
- Base Selenium and other helpers are present here. Initiating the driver and all selenium functions are here.

src/main/java/pages: 
- Page Objects are defined here.

src/test/java/setup:
- Browser launch and close methods are defined with testng before/after annotations.

src/test/java/app/test:
- Tests for all 3 pages are mentioned here.
- Only positive flow is covered.
- Assertions are also done here.

- Click RunAll to run all the tests. Or use maven command - "mvn clean test" or "mvn clean -Dtest=verifyAlertBox test", "mvn clean -Dtest=verifyBasicForm test", "mvn clean -Dtest=verifyRegistration test"
- Check the output under test-output folder.
