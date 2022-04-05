package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;

public class AutocompleteTest extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(AccordionTest.class);
    private static final String path = "https://seleniumui.moderntester.pl/autocomplete.php";

    @Test
    void automationPracticeAutocomplete() {
        driver.get(path);

        WebElement searchBar = driver.findElement(By.cssSelector("#search"));
        searchBar.sendKeys("a");
        List<WebElement> items = driver.findElements(By.cssSelector("#ui-id-1 .ui-menu-item div"));
        WebElement selectedOption = items.get(new Random().nextInt(items.size()));
        String selectedOptionSave = selectedOption.getText();
        System.out.println("wybrana opcja: " + selectedOptionSave);
        selectedOption.click();
        System.out.println("wpisana opcja: " + searchBar.getAttribute("value"));
        assertThat("Incorrect text", searchBar.getAttribute("value").equals(selectedOptionSave));
    }
}