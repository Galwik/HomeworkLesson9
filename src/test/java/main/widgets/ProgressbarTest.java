package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class ProgressbarTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/progressbar.php";

    @Test
    void automationPracticeProgressbar() {
        driver.get(path);

        WebElement progressbarText = driver.findElement(By.cssSelector(".progress-label"));
        WebDriverWait waitForComplete = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForComplete.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"), "Complete!"));

        assertThat("Test closed too fast", progressbarText
                .getText().equals("Complete!"));
    }
}