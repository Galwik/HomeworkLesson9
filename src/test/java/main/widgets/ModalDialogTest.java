package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ModalDialogTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/modal-dialog.php";

    @Test
    void automationPracticeModalDialog() {
        driver.get(path);
        String nameString = "Kamil Gawlicki";
        String emailString = "kgawlicki@sii.pl";
        String passwordString = "admin";

        driver.findElement(By.cssSelector("#create-user")).click();
        WebDriverWait waitForDialogForm = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitForDialogForm.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dialog-form")));

        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.clear();
        name.sendKeys(nameString);
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.clear();
        email.sendKeys(emailString);
        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.clear();
        password.sendKeys(passwordString);
        driver.findElement(By.cssSelector(".ui-dialog-buttonset button:first-child")).click();

        WebDriverWait waitForUsersUpdate = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitForUsersUpdate.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#users tbody")));

        List<WebElement> userInfo = driver.findElements(By.cssSelector("#users tbody tr:last-child td"));

        assertThat("Incorrect name", userInfo.get(0)
                .getText().equals(nameString));
        assertThat("Incorrect email", userInfo.get(1)
                .getText().equals(emailString));
        assertThat("Incorrect password", userInfo.get(2)
                .getText().equals(passwordString));
    }
}