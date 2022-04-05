package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MenuTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/menu-item.php";

    @Test
    void automationPracticeMenu() {
        driver.get(path);

        WebElement musicButton = driver.findElement(By.cssSelector("#ui-id-9"));
        musicButton.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-13")));

        WebElement jazzButton = driver.findElement(By.cssSelector("#ui-id-13"));
        jazzButton.click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-16")));

        WebElement modernButton = driver.findElement(By.cssSelector("#ui-id-16"));
        modernButton.click();
    }
}