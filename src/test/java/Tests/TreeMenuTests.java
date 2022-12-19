package Tests;

import PageElements.TreeMenuPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

@DisplayName("Tree Menu links respond testing")
@Tag("treeMenuTests")
public class TreeMenuTests extends AbstractTest {
    private WebDriver driver;

    @BeforeEach
    public void goToApplication() throws IOException {

        driver = goTo("https://tlc.thinkorswim.com/center/howToTos/thinkManual");
    }

    @Test
    public void linksWorkingTest() throws IOException{

        TreeMenuPage treeMenu = new TreeMenuPage(driver);
        driver.findElement(treeMenu.expandAll).click();
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='List-interop__itemGroup_level_0'] a"));
        checkLinksRespond(links);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
