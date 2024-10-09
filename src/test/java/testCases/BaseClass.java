package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    public Logger logger;   //Log4j
    public static Properties p;


    @BeforeClass
    public void setup() throws IOException {
        //loading config.properties file
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        switch (p.getProperty("browser").toLowerCase()){
            case "chrome" : driver = new ChromeDriver();break;
            case "firefox" : driver = new FirefoxDriver();break;
            default: System.out.println("Invalid browser name...");return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(p.getProperty("appURL")); // reading app url from properties file
        driver.manage().window().maximize();
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}

