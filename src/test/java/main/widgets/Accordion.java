package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Accordion extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(Accordion.class);
    private static final String path = "https://seleniumui.moderntester.pl/accordion.php";

    @Test
    void automationPraticeAccordion() throws InterruptedException {
        driver.get(path);

        System.out.println(driver.findElement(By.cssSelector("#ui-id-2 p")).getText());
        System.out.println();

        driver.findElement(By.cssSelector("#ui-id-3")).click();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-4")));
        System.out.println(driver.findElement(By.cssSelector("#ui-id-4 p")).getText());
        System.out.println();

        driver.findElement(By.cssSelector("#ui-id-5")).click();
//        WebDriverWait wait2 = new WebDriverWait(driver, 10);
//        wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-6")));
        Thread.sleep(500);
        System.out.println(driver.findElement(By.cssSelector("#ui-id-6")).getText());
        System.out.println();

        driver.findElement(By.cssSelector("#ui-id-7")).click();
//        WebDriverWait wait3 = new WebDriverWait(driver, 10);
//        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-8")));
        Thread.sleep(500);
        driver.findElements(By.cssSelector("#ui-id-8")).forEach(x -> System.out.println(x.getText()));
        System.out.println();
    }
}