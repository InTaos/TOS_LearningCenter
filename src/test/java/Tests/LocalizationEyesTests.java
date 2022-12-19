package Tests;

import PageElements.HeaderPage;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.class)
@DisplayName("Localization Eyes testing")
@Tag("localisationEyesTests")
public class LocalizationEyesTests extends AbstractTest{

    private WebDriver driver;
    private Eyes eyes;
    private String apiKey = System.getenv("MY_APPLITOOLS_API_KEY");
    private static ClassicRunner runner;
    private Configuration testConfig;
    private HeaderPage header;

    @BeforeEach
    public void goToApplication() throws IOException {

        runner = new ClassicRunner();
        driver = goTo("https://tlc.thinkorswim.com/center/reference");

        header = new HeaderPage(driver);
        eyes = new Eyes();
        eyes.setApiKey(apiKey);
        eyes.setForceFullPageScreenshot(true);
        eyes.setAppName("LocalizationTest");
        testConfig = eyes.getConfiguration();

    }


    @Order(1)
    @Test
    public void changeLanguageToChineseSimplifiedTest() {

        testConfig.setTestName("Chinese(simplified)");
        eyes.setConfiguration(testConfig);
        eyes.open(driver);
        header.changeLanguage(2);
        eyes.checkWindow();
    }


    @Order(2)
    @Test
    public void changeLanguageToChineseTraditionalTest() {

        testConfig.setTestName("Chinese - Traditional");
        eyes.setConfiguration(testConfig);
        eyes.open(driver);
        header.changeLanguage(3);
        eyes.checkWindow();
    }

    @Order(2)
    @Test
    public void changeLanguageToEnglishTest() {

        testConfig.setTestName("English");
        eyes.setConfiguration(testConfig);
        eyes.open(driver);
        header.changeLanguage(1);
        eyes.checkWindow();
    }

    @AfterEach
    public void tearDown(){

        eyes.closeAsync();
        eyes.abortIfNotClosed();
        driver.quit();
    }

    @AfterAll
    public static void printResults() {

        // Close the batch and report visual differences to the console.
        // Note that it forces JUnit to wait synchronously for all visual checkpoints to complete.
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
    }

}
