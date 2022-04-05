package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccordionTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/accordion.php";

    @Test
    void automationPracticeAccordion() {
        driver.get(path);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-2")));
        System.out.println(driver.findElement(By.cssSelector("#ui-id-2")).getText());
        System.out.println();

        driver.findElement(By.cssSelector("#ui-id-3")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-4 p")));
        System.out.println(driver.findElement(By.cssSelector("#ui-id-4 p")).getText());
        System.out.println();

        driver.findElement(By.cssSelector("#ui-id-5")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait2.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-6 ul li:last-child")));
        System.out.println(driver.findElement(By.cssSelector("#ui-id-6")).getText());
        System.out.println();

        driver.findElement(By.cssSelector("#ui-id-7")).click();
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait3.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ui-id-8 p:last-child")));
        driver.findElements(By.cssSelector("#ui-id-8")).forEach(x -> System.out.println(x.getText()));
        System.out.println();
    }
}