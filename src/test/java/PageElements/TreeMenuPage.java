package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TreeMenuPage extends AbstractPage {
    public TreeMenuPage(WebDriver driver) {
        super(driver);
    }
    public By expandAll = By.cssSelector("button[aria-label='Expand All']");


}
