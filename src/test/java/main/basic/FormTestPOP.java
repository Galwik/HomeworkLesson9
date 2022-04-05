package main.basic;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class FormTestPOP extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/form.php";

    @Test
    void fillForm() {
        driver.get(path);

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Kamil");
        formPage.setLastName("Gawlicki");
        formPage.setEmail("kgawlicki@sii.pl");
        formPage.setRandomSex();
        formPage.setAge("23");
        formPage.setRandomYearsOfExperience();
        formPage.setProfessionToAutomationTester();
        formPage.setRandomContinent();
        formPage.setSwitchAndWaitSeleniumCommand(driver);
        formPage.uploadFile("src/main/resources/fileToUpload");
        formPage.signIn();

        assertThat("Incorrect text", driver.findElement(By.cssSelector("#validator-message"))
                .getText().equals("Form send with success"));
    }
}