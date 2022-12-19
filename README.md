# TOS_LearningCenter
Automation testing framework for "Thinkorswim" Web Learning Center. Techologies: JAVA, SELENIUM, JUNIT5, GRADLE, APPLITOOLS EYES.

All TESTS are found in **src/test/Tests**.

All methods and page elements are found in **src/test/PageElements**.

**AbstractTest** class contains all reusable methods and browsers needed for tests.
**AbstractPage** class contains all reusable methods needed for page locators. 

**VideoTests** class must be run in non-headless mode!

In **build.gradle** file we can perform filtering of the test by tag, and also we can switch from one browser to another by just comment or uncomment the expressions. 

Each tests works with freshly instantiated browser.
**Default browser is chrome-headless!**
To start the tests double CTR and type **"gradle clean test"**.

Functionalities: 
1. Browsers: Chrome, Firefox, Edge(headless and non-headless mode)
2. Eyes tools integration for Localization tests

Tests:
1. Video tests: fullscreen, fullscreen to normal screen, video play validation
2. Localization tests - Eyes tool & hardcoded chinese text
3. Search bar tests
4. Tree menu and Footer links network respond tests
5. Logo to main page tests
6. Dark & Light Themes tests
