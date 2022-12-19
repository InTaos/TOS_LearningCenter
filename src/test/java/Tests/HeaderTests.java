package Tests;
import PageElements.HeaderPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;


    @TestMethodOrder(MethodOrderer.class)
    @DisplayName("Header elements testing")
    @Tag("headerTests")
    public class HeaderTests extends AbstractTest{

   private  WebDriver driver;

    @BeforeEach
    public void goToApplication() throws IOException {
        driver = goTo("https://tlc.thinkorswim.com/center");
    }

    @Order(1)
    @Test
    void LoginValidationTest() {
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(url,"https://tlc.thinkorswim.com/center");
    }

    @Order(2)
    @Test()
    void logoToMainPageTest(){
        HeaderPage header = new HeaderPage(driver);
        String urlLogin = driver.getCurrentUrl();
        header.pressLogo();
        String urlAfterLogoClick = driver.getCurrentUrl();
        Assertions.assertEquals(urlLogin,urlAfterLogoClick);
    }

    @Order(3)
    @Test
    void searchTest(){
        HeaderPage header = new HeaderPage(driver);
        String search = "Order Types";
        header.sendKeyToSearchBar(search);
        WebElement searchResult = driver.findElement(By.xpath("//ul[@class='bower_components-dx-components-src-components-List-__List__container List-interop__container']/li[1]"));
        searchResult.click();
        String title = header.getTitleText();
        Assertions.assertEquals(search,title);
    }


    @Order(4)
    @Test
    public void changeLanguageToChineseSimplifiedTest() {
        HeaderPage header = new HeaderPage(driver);
        header.changeLanguage(2);
        String pageTitleChinese = driver.findElement(By.cssSelector("h2[class='heading__title']")).getText();
        String chineseText = "学习中心";
        Assertions.assertEquals(pageTitleChinese,chineseText);
    }

        @Order(5)
        @Test
        public void changeLanguageToChineseTraditionalTest() {
            HeaderPage header = new HeaderPage(driver);
            header.changeLanguage(3);
            String pageTitleChinese = driver.findElement(By.cssSelector("h2[class='heading__title']")).getText();
            String chineseText = "學習中心";
            Assertions.assertEquals(pageTitleChinese,chineseText);
        }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
