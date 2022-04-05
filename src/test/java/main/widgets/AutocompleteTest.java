package main.widgets;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutocompleteTest extends TestBase {
    private static final Logger log = LoggerFactory.getLogger(AccordionTest.class);
    private static final String path = "https://seleniumui.moderntester.pl/autocomplete.php";

    @Test
    void automationPracticeAutocomplete() {
        driver.get(path);

        WebElement searchBar = driver.findElement(By.cssSelector("#search"));
        searchBar.sendKeys("a");
        List<WebElement> listOfItems = driver.findElements(By.cssSelector("#ui-id-1 .ui-menu-item div"));
//        List<String> listOfItemsText = new ArrayList<>();
//        listOfItems.forEach(x -> listOfItemsText.add(x.getText()));

        int random = new Random().nextInt(listOfItems.size());
        WebElement selectedOption = listOfItems.get(random);
        System.out.println("wybrana opcja: " + selectedOption.getText());
        selectedOption.click();
        System.out.println("wybrana opcja po kliknięciu: " + selectedOption.getText());
        System.out.println("wpisana opcja: " + searchBar.getText());
        assertThat("Incorrect text", searchBar.getText().equals(listOfItems.get(random).getText()));




    }
}