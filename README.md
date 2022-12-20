# TOS_LearningCenter
Automation testing framework for "Thinkorswim" Web Learning Center. Techologies: JAVA, SELENIUM, JUNIT5, GRADLE, APPLITOOLS EYES.

All TESTS are found in src/test/Tests.

All methods and page elements are found in src/test/PageElements.

AbstractTest class contains all reusable methods and browsers needed for tests. AbstractPage class contains all reusable methods needed for page locators.

VideoTests class must be run in non-headless mode!

In build.gradle file we can perform filtering of the test by tag, and also we can switch from one browser to another by just comment or uncomment the expressions.

Default browser is Chrome-headless! 
Each of the tests works with freshly instantiated browser! 
Tests are executed parallelly! 
To start the tests, double CTR and type "gradle clean test".

In order to see the results of Eyes tools you must have an account in: https://applitools.com/, from where you take API KEY. You must replace the API KEY in the **LocalizationEyesTests.java** class in variable **private String apiKey = "<>"**.

Functionalities:
1. Browsers: Chrome, Firefox, Edge (headless and non-headless mode)
2. Eyes tool integration for Localization tests



Tests:
1. Video tests: full screen, full screen to normal screen, video play validation
2. Localization tests - Eyes tool & hard-coded Chinese text
3. Search bar tests
4. Tree menu and Footer links network respond tests
5. Logo to main page tests
6. Dark & Light Themes tests

..
