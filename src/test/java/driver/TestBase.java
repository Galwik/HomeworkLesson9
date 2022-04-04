package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    private static Logger logger = LoggerFactory.getLogger("TestDriver.class");
    public static WebDriver driver;


    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        logger.info(">>>DRIVER INITIATED PROPERLY");
    }

    @BeforeEach
    void beforeEach() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void afterEach() {
        driver.quit();
        logger.info(">>>DRIVER CLOSED PROPERLY");
    }
}