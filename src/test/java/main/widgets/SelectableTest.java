package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class SelectableTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(AccordionTest.class);
    private static final String path = "https://seleniumui.moderntester.pl/selectmenu.php";

    @Test
    void automationPracticeAccordion() throws InterruptedException {
        driver.get(path);

        WebElement speedButton = driver.findElement(By.cssSelector("#speed-button"));
        speedButton.click();
        List<WebElement> listOfSpeed = driver.findElements(By.cssSelector("#speed-menu li"));
        listOfSpeed.get(new Random().nextInt(listOfSpeed.size())).click();

        WebElement fileButton = driver.findElement(By.cssSelector("#speed-button"));
        fileButton.click();
        List<WebElement> listOfFile = driver.findElements(By.cssSelector("#speed-menu li"));
        listOfFile.get(new Random().nextInt(listOfSpeed.size())).click();

        WebElement numberButton = driver.findElement(By.cssSelector("#number-button"));
        numberButton.click();
        List<WebElement> listOfNumbers = driver.findElements(By.cssSelector("#number-menu div"));
        listOfNumbers.get(4).click();

        WebElement titleButton = driver.findElement(By.cssSelector("#salutation-button"));
        titleButton.click();
        List<WebElement> listOfTitles = driver.findElements(By.cssSelector("#salutation-menu :not(li:first-child) div"));
        listOfTitles.get(new Random().nextInt(listOfSpeed.size())).click();

        Thread.sleep(5000);
    }
}