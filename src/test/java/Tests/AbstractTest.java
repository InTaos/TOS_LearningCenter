package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class AbstractTest {
    WebDriver driver;

    public String lightTheme(){
        driver.findElement(By.cssSelector("span[class*='schemeIcon_light']")).click();
        return driver.findElement(By.id("main")).getCssValue("color");
    }

    public String darkTheme(){
        driver.findElement(By.xpath("//span[contains(text(),'Dark')]")).click();
        return driver.findElement(By.id("main")).getCssValue("color");

    }
    public void linkRespond(By linkSelector) throws IOException {
        WebElement link = driver.findElement(linkSelector);

        String url = link.getAttribute("href");
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        System.out.println(url);
        if(responseCode > 400)
        {
            Assertions.fail();
        }

    }
    public void checkLinksRespond(List<WebElement> links) throws IOException {


        for (WebElement link : links)
        {

            String url = link.getAttribute("href");
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            System.out.println(url);
            if(responseCode > 400)
            {
                Assertions.fail();
            }

        }
    }
    public WebDriver goTo(String url) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "//src//main//java//Resources//GlobalData.properties");
        prop.load(fis);
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

        if (browser.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            if (browser.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));//full screen

        } else if (browser.contains("edge")) {
            EdgeOptions options = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            if (browser.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new EdgeDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));//full screen

        } else if (browser.contains("firefox")) {

            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            if (browser.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new FirefoxDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));//full screen
        }
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }
}
