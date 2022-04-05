package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

public class SliderTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/slider.php";

    @Test
    void automationPracticeSlider() {
        driver.get(path);

        WebElement handle = driver.findElement(By.cssSelector("#custom-handle"));
        handle.click();

        moveHandle(handle, 50);
        assertPosition(handle, 50);
        restart(handle);

        moveHandle(handle, 80);
        assertPosition(handle, 80);
        restart(handle);

        moveHandle(handle, 80);
        assertPosition(handle, 80);
        restart(handle);

        moveHandle(handle, 20);
        assertPosition(handle, 20);
        restart(handle);

        assertPosition(handle, 0);
    }

    private void moveHandle(WebElement handle, int position) {
        for (int i = 0; i < position; i++) {
            handle.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    private void restart(WebElement handle) {
        int x = Integer.parseInt(handle.getText());
        for (int i = 0; i < x; i++) {
            handle.sendKeys(Keys.ARROW_LEFT);
        }
    }

    private void assertPosition(WebElement handle, Integer expectedPosition) {
        assertThat("Wrong slider position \nExpected: "
                        + expectedPosition + "\n  Actual: " + handle.getText()
                , handle.getText().equals(expectedPosition.toString()));
    }
}