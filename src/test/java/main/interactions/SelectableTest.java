package main.interactions;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class SelectableTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/selectable.php";

    @Test
    void automationPracticeSelectable() {
        driver.get(path);

        List<WebElement> items = driver.findElements(By.cssSelector("#selectable li"));
        WebElement key1 = items.get(0);
        WebElement key3 = items.get(2);
        WebElement key4 = items.get(3);

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(key1).click(key3).click(key4).build().perform();

        assertThat("Wrong items selected", driver.findElement(By.cssSelector("#select-result")).getText().equals("#1 #3 #4"));
    }
}