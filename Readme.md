CHOCO TEST INSTRUCTIONS:

- Clone the app code(my-app).
- Import the Project into any IDE(eclipse/Intellij).
- Open pom.xml file and download the maven dependency and build the project. 

Directories Definition: 

src/main/java/app/helpers:
- Base Selenium and CONSTANT file is there. Initiating the driver and all selenium functions are here.
- Open The CONSTANT interface and change the `APP_PATH` to the path where app apk exists. This can be loaded via System properties too.

src/main/java/app/pages: 
- Page Objects are defined here. Here I considered Onboarding Page as single page.

src/test/java/app/setup:
- App launch and close methods are defined with testng before/after annotations.

src/test/java/app/test:
- Actual Test is mentioned here.
- Positive flow, with correct data.
- Negative flow, with incorrect phone number.
- Negative flow, with incorrect sms code.
- Assertions are also done here.

- Click RunAll to run all the tests. Or use maven command - "mvn clean test" or "mvn clean -Dtest=verifyAppFeature test"
- Check the output under test-output folder.

TextCases.txt:
- All test cases in Gherkin format are present here.