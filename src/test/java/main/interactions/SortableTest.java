package main.interactions;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class SortableTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/sortable.php";

    @Test
    void automationPracticeSortable() {
        driver.get(path);
        WebElement item1 = driver.findElement(By.xpath("//li[contains(text(),'Item 1')]"));
        WebElement item2 = driver.findElement(By.xpath("//li[contains(text(),'Item 2')]"));
        WebElement item3 = driver.findElement(By.xpath("//li[contains(text(),'Item 3')]"));
        WebElement item4 = driver.findElement(By.xpath("//li[contains(text(),'Item 4')]"));
        WebElement item5 = driver.findElement(By.xpath("//li[contains(text(),'Item 5')]"));
        WebElement item6 = driver.findElement(By.xpath("//li[contains(text(),'Item 6')]"));
        WebElement item7 = driver.findElement(By.xpath("//li[contains(text(),'Item 7')]"));

        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);

        System.out.println("Your random array: " + Arrays.toString(array));


        Actions action = new Actions(driver);
        for (Integer integer : array) {

            switch (integer) {
                case 1:
                    moveElement(item1, action);
                    continue;
                case 2:
                    moveElement(item2, action);
                    continue;
                case 3:
                    moveElement(item3, action);
                    continue;
                case 4:
                    moveElement(item4, action);
                    continue;
                case 5:
                    moveElement(item5, action);
                    continue;
                case 6:
                    moveElement(item6, action);
                    continue;
                case 7:
                    moveElement(item7, action);
            }
        }
        assertThat("Wrong order", driver.findElement(By.cssSelector("#sortable")).getText().equals(buildStringToAssert(array)));
    }

    private void moveElement(WebElement item, Actions action) {
        action.clickAndHold(item)
                .moveToElement(driver.findElement(By.cssSelector("#sortable li:last-child")))
                .moveByOffset(0, 1)
                .release().build().perform();
    }

    private String buildStringToAssert(Integer[] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append("\n");
            }
            sb.append("Item ").append(array[i]);
        }
        return sb.toString();
    }
}