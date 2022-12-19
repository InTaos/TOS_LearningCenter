package Tests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import java.io.IOException;

@TestMethodOrder(MethodOrderer.class)
@DisplayName("Light and Dark theme tests")
@Tag("themeTests")
public class ThemeTests extends AbstractTest{

    @BeforeEach
    public void goToApplication() throws IOException {

        driver = goTo("https://tlc.thinkorswim.com/center");
    }

    @Order(1)
    @Test
    public void lightThemeTest() {

        String color = driver.findElement(By.id("main")).getCssValue("color");
        String lightColor = lightTheme();
        Assertions.assertNotEquals(color,lightColor);
    }


    @Order(2)
    @Test
    public void darkThemeTest(){


        driver.findElement(By.cssSelector("span[class*='schemeIcon_light']")).click();
        String color = driver.findElement(By.id("main")).getCssValue("color");
        String darkColor = darkTheme();
        Assertions.assertNotEquals(color,darkColor);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
