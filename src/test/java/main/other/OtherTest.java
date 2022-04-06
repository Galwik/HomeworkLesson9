package main.other;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class OtherTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/high-site.php";

    @Test
    void automationPracticeScrollToSubmitButton() throws InterruptedException {
        driver.get(path);

        WebElement element = driver.findElement(By.cssSelector(".show-button"));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0,-200)");
        Thread.sleep(3000);
    }
}