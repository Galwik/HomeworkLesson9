package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;


public class DatePickerTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/datepicker.php";
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @Test
    void automationPracticeDatePicker() {
        driver.get(path);

        //1.
        WebElement datePicker = driver.findElement(By.cssSelector("#datepicker"));
        datePicker.click();
        driver.findElement(By.cssSelector(".ui-datepicker-today")).click();

        assertThat("Incorrect today date (1)", driver.findElement(By.cssSelector("#datepicker")).getAttribute("value")
                .equals(LocalDate.now().format(dateFormatter)));

        //2.
        datePicker.click();
        waitASecond();
        getNextMonth().click();
        driver.findElements(By.cssSelector("tbody tr:first-child td"))
                .stream()
                .filter(x -> x.getText().equals("1"))
                .findFirst()
                .ifPresent(WebElement::click);

        assertThat("Incorrect date (2)", driver.findElement(By.cssSelector("#datepicker")).getAttribute("value")
                .equals(LocalDate.of(2022, 5, 1).format(dateFormatter)));

        //3.
        datePicker.click();
        waitASecond();
        for (int i = 0; i < 8; i++) {
            getNextMonth().click();
        }
        driver.findElements(By.cssSelector("tbody tr:last-child td"))
                .stream()
                .filter(x -> x.getText().equals("31"))
                .findFirst()
                .ifPresent(WebElement::click);

        assertThat("Incorrect date (3)", driver.findElement(By.cssSelector("#datepicker")).getAttribute("value")
                .equals(LocalDate.of(2023, 1, 31).format(dateFormatter)));

        //4.
        datePicker.click();
        waitASecond();
        driver.findElement(By.cssSelector(".ui-datepicker-current-day")).click();

        assertThat("Incorrect date (4)", driver.findElement(By.cssSelector("#datepicker")).getAttribute("value")
                .equals(LocalDate.of(2023, 1, 31).format(dateFormatter)));

        //5.
        datePicker.click();
        waitASecond();
        for (int i = 0; i < 10; i++) {
            getPreviousMonth().click();
        }
        int bound = driver.findElements(By.cssSelector("tbody tr td:not(.ui-datepicker-other-month)")).size();
        int randomDay = new Random().nextInt(bound) + 1;

        driver.findElements(By.cssSelector("tbody tr td:not(.ui-datepicker-other-month)"))
                .stream()
                .filter(x -> x.getText().equals(Integer.toString(randomDay)))
                .findFirst()
                .ifPresent(WebElement::click);

        assertThat("Incorrect date (5)", driver.findElement(By.cssSelector("#datepicker")).getAttribute("value")
                .equals(LocalDate.of(2022, 3, randomDay).format(dateFormatter)));

        //6.
        datePicker.click();
        int randomMonth = new Random().nextInt(12) + 3;
        waitASecond();
        for (int i = 0; i < randomMonth; i++) {
            getPreviousMonth().click();
        }
        int bound2 = driver.findElements(By.cssSelector("tbody tr td:not(.ui-datepicker-other-month)")).size();
        int randomDay2 = new Random().nextInt(bound2) + 1;

        driver.findElements(By.cssSelector("tbody tr td:not(.ui-datepicker-other-month)"))
                .stream()
                .filter(x -> x.getText().equals(Integer.toString(randomDay2)))
                .findFirst()
                .ifPresent(WebElement::click);

        assertThat("Incorrect date (6)", driver.findElement(By.cssSelector("#datepicker")).getAttribute("value")
                .equals(LocalDate.of(2021, 15 - randomMonth, randomDay2).format(dateFormatter)));
    }

    private WebElement getNextMonth() {
        return driver.findElement(By.cssSelector(".ui-datepicker-next"));
    }

    private WebElement getPreviousMonth() {
        return driver.findElement(By.cssSelector(".ui-datepicker-prev"));
    }

    private void waitASecond() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#ui-datepicker-div"))));
    }
}