package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends AbstractPage {
    WebDriver driver;
    public HeaderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By logo = By.cssSelector("div[class='Logo__logo']");

    private By title = By.xpath("//div[@class='content__container MainContent__content']/h1");

    private By languageSelector = By.cssSelector("span[class='LanguageSelector__label']");

    public void pressLogo(){

        driver.findElement(logo).click();
    }
    public void sendKeyToSearchBar(String search){

        By searchBar = By.cssSelector("input[name='keyword']");
        driver.findElement(searchBar).sendKeys(search);
    }
    public String getTitleText(){

        return driver.findElement(title).getText();
    }
    public void changeLanguage(int index) {

        driver.findElement(languageSelector).click();
        driver.findElement(By.cssSelector("ul[class*='LanguageSelector__menu']>li:nth-child("+ index +")")).click();
    }
}
