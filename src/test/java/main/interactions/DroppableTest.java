package main.interactions;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.assertThat;

public class DroppableTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/droppable.php";

    @Test
    void automationPracticeDroppable() {
        driver.get(path);
        WebElement object = driver.findElement(By.cssSelector("#draggable"));
        WebElement destination = driver.findElement(By.cssSelector("#droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(object, destination).perform();
        assertThat("Object dropped in wrong place", destination.getText().equals("Dropped!"));
    }
}