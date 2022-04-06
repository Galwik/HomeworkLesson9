package main.interactions;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.assertThat;

public class ResizableTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/resizable.php";

    @Test
    void automationPracticeResizable() throws InterruptedException {
        driver.get(path);

        WebElement object = driver.findElement(By.cssSelector("#resizable"));
        WebElement rightHandle = driver.findElement(By.cssSelector(".ui-resizable-e"));
        WebElement downHandle = driver.findElement(By.cssSelector(".ui-resizable-s"));
        WebElement downAndRightHandle = driver.findElement(By.cssSelector(".ui-resizable-se"));

        Integer startWidth = object.getSize().getWidth();
        Integer startHeight = object.getSize().getHeight();

        Actions action = new Actions(driver);

        Thread.sleep(500);
        action.dragAndDropBy(rightHandle, 28, 0).perform();
        int widthAfter1 = object.getSize().getWidth();
        int heightAfter1 = object.getSize().getHeight();
        assertThat("Wrong width", startWidth.equals(widthAfter1 - 10));
        assertThat("Wrong height", startHeight.equals(heightAfter1));

        Thread.sleep(500);
        action.dragAndDropBy(downHandle, 0, 28).perform();
        int widthAfter2 = object.getSize().getWidth();
        int heightAfter2 = object.getSize().getHeight();
        assertThat("Wrong width", startWidth.equals(widthAfter2 - 10));
        assertThat("Wrong height", startHeight.equals(heightAfter2 - 10));

        Thread.sleep(500);
        action.dragAndDropBy(downAndRightHandle, 28, 28).perform();
        int widthAfter3 = object.getSize().getWidth();
        int heightAfter3 = object.getSize().getHeight();
        assertThat("Wrong width", startWidth.equals(widthAfter3 - 20));
        assertThat("Wrong height", startHeight.equals(heightAfter3 - 20));
        Thread.sleep(500);
    }
}