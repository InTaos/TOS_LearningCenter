package Tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


@DisplayName("Feature section: video testing")
@Tag("featuredTests")
public class FeaturedTests extends AbstractTest{
    private WebDriver driver;

   @BeforeEach
   public void goToApplication() throws IOException {

       driver = goTo("https://tlc.thinkorswim.com/center");
   }

    @Test
    public void urlFirstItemResponseTest() throws IOException {

        By firstItemLocator = By.cssSelector("div[class='featured__items'] a:nth-child(1)");
        linkRespond(firstItemLocator);
    }
    @Test
    public void urlSecondItemResponseTest() throws IOException {

        By secondItemLocator = By.cssSelector("div[class='featured__items'] a:nth-child(2)");
        linkRespond(secondItemLocator);
    }
    @Test
    public void urlThirdItemResponseTest() throws IOException {

        By thirdItemLocator = By.cssSelector("div[class='featured__items'] a:nth-child(3)");
        linkRespond(thirdItemLocator);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
