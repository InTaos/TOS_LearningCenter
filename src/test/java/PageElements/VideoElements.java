package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class VideoElements extends AbstractPage {

   public WebElement videoContainer = driver.findElement(By.cssSelector("video[class*='VideoPlayer']"));
    public VideoElements(WebDriver driver) {
        super(driver);
    }

    public void videoPlay(){
        By buttonVideoPlay = waitForElementToBeClickable(By.cssSelector("div[class='Overlay__inner Overlay__inner_isSingleVideo']"));
        driver.findElement(buttonVideoPlay).click();
    }

    public void videoFullScreen(){
        By buttonFullScreen = By.cssSelector("button[aria-label='Full screen']");
        WebElement videoContainer = driver.findElement(By.cssSelector("video[class='VideoPlayer__container']"));
        Actions action = new Actions(driver);
        action.moveToElement(videoContainer).perform();
        waitForElementToBeClickable(buttonFullScreen);
        driver.findElement(buttonFullScreen).click();
    }
    public String videoGetCurrentTime(long milis) throws InterruptedException {

        By videoTime = waitForElementToBeClickable(By.cssSelector("span[class='VideoPlayerControls__controls__time']"));
        Thread.sleep(milis);
        return driver.findElement(videoTime).getText();
    }

}
