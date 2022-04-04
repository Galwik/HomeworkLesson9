package main.basic;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;

public class FormTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/form.php";

    @Test
    void fillForm() {
        driver.get(path);
        WebElement firstName = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstName.sendKeys("Kamil");

        WebElement lastName = driver.findElement(By.cssSelector("#inputLastName3"));
        lastName.sendKeys("Gawlicki");

        WebElement email = driver.findElement(By.cssSelector("#inputEmail3"));
        email.sendKeys("kgawlicki@sii.pl");

        List<WebElement> listOfSex = driver.findElements(By.cssSelector("[name='gridRadiosSex']"));
        listOfSex.get(new Random().nextInt(listOfSex.size())).click();

        WebElement age = driver.findElement(By.cssSelector("#inputAge3"));
        age.clear();
        age.sendKeys("23");

        List<WebElement> yearsOfExperience = driver.findElements(By.cssSelector("[name='gridRadiosExperience']"));
        yearsOfExperience.get(new Random().nextInt(yearsOfExperience.size())).click();

        WebElement profession = driver.findElement(By.cssSelector("#gridCheckAutomationTester"));
        profession.click();

        List<WebElement> continents = driver.findElements(By.cssSelector("#selectContinents :not([value=''])"));
        continents.get(new Random().nextInt(continents.size())).click();

        WebElement seleniumCommand1 = driver.findElement(By.cssSelector("[value='switch-commands']"));
        WebElement seleniumCommand2 = driver.findElement(By.cssSelector("[value='wait-commands']"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(seleniumCommand1).click(seleniumCommand2).build().perform();

        File fileToUpload = new File("src/main/resources/fileToUpload");
        WebElement uploadFile = driver.findElement(By.cssSelector("#chooseFile"));
        uploadFile.sendKeys(fileToUpload.getAbsolutePath());

        WebElement signInButton = driver.findElement(By.cssSelector(".btn-primary"));
        signInButton.click();

        assertThat("Incorrect text", driver.findElement(By.cssSelector("#validator-message"))
                .getText().equals("Form send with success"));
    }
}