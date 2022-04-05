package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SelectableTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/selectmenu.php";

    @Test
    void automationPracticeSelectableTest() {
        driver.get(path);

        driver.findElement(By.cssSelector("#speed-button")).click();
        List<WebElement> listOfSpeed = driver.findElements(By.cssSelector("#speed-menu li"));
        listOfSpeed.get(new Random().nextInt(listOfSpeed.size())).click();

        driver.findElement(By.cssSelector("#files-button")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Some unknown file')]")).click();

        driver.findElement(By.cssSelector("#number-button")).click();
        driver.findElement(By.cssSelector("#number-menu :nth-child(4)")).click();

        driver.findElement(By.cssSelector("#salutation-button")).click();
        List<WebElement> listOfTitles = driver.findElements(By.cssSelector("#salutation-menu :not(li:first-child) div"));
        listOfTitles.get(new Random().nextInt(listOfSpeed.size())).click();
    }
}