package main.basic;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class AlertsTests extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(AlertsTests.class);
    private static final String path = "https://seleniumui.moderntester.pl/alerts.php";

    @Test
    void simpleAlertPopUp() {
        driver.get(path);
        WebElement simpleAlertButton = driver.findElement(By.cssSelector("#simple-alert"));
        simpleAlertButton.click();
        driver.switchTo().alert().accept();
        assertThat("Incorrect text", driver.findElement(By.cssSelector("#simple-alert-label"))
                .getText().equals("OK button pressed"));
        log.info(">>>>>  Simple Alert Pop Up");
    }

    @Test
    void promptAlertBox() {
        driver.get(path);
        WebElement promptPopUpButton = driver.findElement(By.cssSelector("#prompt-alert"));
        promptPopUpButton.click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        assertThat("Incorrect text", driver.findElement(By.cssSelector("#prompt-label"))
                .getText().equals("Hello Lord Vader! How are you today?"));
        log.info(">>>>>  Prompt Alert box");
    }

    @Test
    void confirmAlertbox() {
        driver.get(path);
        WebElement confirmPopUpButton = driver.findElement(By.cssSelector("#confirm-alert"));
        confirmPopUpButton.click();
        driver.switchTo().alert().accept();
        assertThat("Incorrect text", driver.findElement(By.cssSelector("#confirm-label"))
                .getText().equals("You pressed OK!"));
        confirmPopUpButton.click();
        driver.switchTo().alert().dismiss();
        assertThat("Incorrect text", driver.findElement(By.cssSelector("#confirm-label"))
                .getText().equals("You pressed Cancel!"));
        log.info(">>>>>  Confirm Alert Box");
    }

    @Test
    void delayedAlert() {
        driver.get(path);
        WebElement delayedAlertButton = driver.findElement(By.cssSelector("#delayed-alert"));
        delayedAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        assertThat("Incorrect text", driver.findElement(By.cssSelector("#delayed-alert-label"))
                .getText().equals("OK button pressed"));
        log.info(">>>>>  Delayed Alert");
    }
}