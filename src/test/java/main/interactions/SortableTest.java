package main.interactions;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortableTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/sortable.php";

    @Test
    void automationPracticeDraggable() {
        driver.get(path);

        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> list = Arrays.asList(array);

        Collections.shuffle(list);
        list.toArray(array);
        System.out.println("Your random array: " + Arrays.toString(array));

        List<WebElement> items = driver.findElements(By.cssSelector("#sortable li"));

        Actions action = new Actions(driver);

//        assertThat("Wrong order",);
    }
}