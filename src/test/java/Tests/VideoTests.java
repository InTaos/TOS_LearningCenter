package Tests;

import PageElements.VideoElements;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;

@TestMethodOrder(MethodOrderer.class)
@Tag("videoTests")
public class VideoTests extends AbstractTest {

    @BeforeEach
    public void goToApplication() throws IOException {

        driver = goTo("https://tlc.thinkorswim.com/center/howToTos/thinkManual/Getting-Started");
    }

    @Test
    @Order(1)
    public void videoPlayTest() throws InterruptedException {
        VideoElements video = new VideoElements(driver);
        video.videoPlay();
        String currentTime = video.videoGetCurrentTime(4000);
        Assertions.assertNotEquals(currentTime,"00:00");
    }

    @Test
    @Order(2)
    public void videoFullScreenTest() {

        VideoElements video = new VideoElements(driver);
        video.videoPlay();
        Dimension size = driver.manage().window().getSize();
        int height = size.getHeight();
        int width =  size.getWidth();
        System.out.println("height " + height + " width " + width);
        video.videoFullScreen();
        Dimension fullSize = driver.manage().window().getSize();
        int fullHeight = fullSize.getHeight();
        int fullWidth =  fullSize.getWidth();
        System.out.println("Full Height " + fullHeight + " Full Width " + fullWidth);
        Assertions.assertNotEquals(height,fullHeight);
        Assertions.assertNotEquals(width,fullWidth);
    }


    @Test
    @Order(3)
    public void videoFullScreenToMidScreenTest() throws InterruptedException {


        VideoElements video = new VideoElements(driver);
        video.videoPlay();
        video.videoFullScreen();
        Dimension fullSize = driver.manage().window().getSize();
        int fullHeight = fullSize.getHeight();
        int fullWidth =  fullSize.getWidth();
        Thread.sleep(2000);

        Actions action = new Actions(driver);
        action.doubleClick(video.videoContainer).perform();


        Thread.sleep(2000);
        Dimension size = driver.manage().window().getSize();
        int height = size.getHeight();
        int width =  size.getWidth();
        System.out.println("Full Height " + fullHeight + " Full Width " + fullWidth);
        System.out.println("height " + height + " width " + width);
        Assertions.assertNotEquals(fullHeight,height);
        Assertions.assertNotEquals(fullWidth,width);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
