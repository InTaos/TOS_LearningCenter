# TOS_LearningCenterAI
Automation testing framework for "Thinkorswim" Web Learning Center. Tech: JAVA, SELENIUM, JUNIT5, GRADLE, APPLITOOLS EYES 

All tests are found in **src/test/Tests**

All methods and page elements are found in **src/test/PageElements**

**AbstractTest** class contains all reusable methods and browsers needed for tests.
**AbstractPage** class contains all reusable methods needed for page locators. 

**VideoTests** class must be run in non-headless mode!

In **build.gradle** file we can perform filtering of the test by tag, and also we can switch from one browser to another by just comment or uncomment the expressions. 
