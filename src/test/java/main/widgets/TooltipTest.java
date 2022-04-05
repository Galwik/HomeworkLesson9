package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class TooltipTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/tooltip.php";

    @Test
    void automationPracticeTooltip() {
        driver.get(path);

        WebElement bar = driver.findElement(By.cssSelector("#age"));
        bar.click();
        WebDriverWait waitForTolltip = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitForTolltip.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-tooltip-content")));

        String actualText = driver.findElement(By.cssSelector(".ui-tooltip-content")).getText();
        String expectedText = "We ask for your age only for statistical purposes.";
        assertThat("Wrong text \nExpected: "
                + expectedText + "\n  Actual: " + actualText, actualText.equals(expectedText));
    }
}