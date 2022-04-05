package main.interactions;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DraggableTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/draggable.php";

    @Test
    void automationPracticeDraggable() throws InterruptedException {
        driver.get(path);
        driver.manage().window().maximize();
        WebElement object = driver.findElement(By.cssSelector("#draggable"));

        Actions action = new Actions(driver);
        Thread.sleep(500);
        action.dragAndDropBy(object, 1000, -100).build().perform();
        Thread.sleep(500);
        action.dragAndDropBy(object, 0, 600).build().perform();
        Thread.sleep(500);
        action.dragAndDropBy(object, -750, -350).build().perform();
        Thread.sleep(500);
        action.dragAndDropBy(object, -750, 350).build().perform();
        Thread.sleep(500);
    }
}