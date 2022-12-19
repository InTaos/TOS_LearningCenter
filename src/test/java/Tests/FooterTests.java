package Tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

@DisplayName("Footer links respond testing")
@Tag("footerTests")
public class FooterTests extends AbstractTest  {
    private WebDriver driver;

    @BeforeEach
    public void goToApplication() throws IOException {

       driver = goTo("https://tlc.thinkorswim.com/center");
    }

    @Test
    public void linksRespondTest() throws IOException {

        List<WebElement> links = driver.findElements(By.cssSelector("a[class='Footer__menu__link']"));
         checkLinksRespond(links);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
