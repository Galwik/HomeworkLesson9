package main.basic;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablesTest extends TestBase {
    private static final String path = "https://seleniumui.moderntester.pl/table.php";


    @Test
    void tablesTest() {
        driver.get(path);
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        for (WebElement row : rows) {
            String rank = row.findElement(By.cssSelector("th")).getText();
            List<WebElement> elements = row.findElements(By.cssSelector("td"));
            String peak = elements.get(0).getText();
            String mountainRange = elements.get(1).getText();
            String state = elements.get(2).getText();
            String height = elements.get(3).getText();

            if (state.contains("Switzerland") && Integer.parseInt(height) > 4000){
                System.out.println("Rank: " + rank + "\n"
                 + "Peak: " + peak + "\n"
                + "Mountain range: " + mountainRange + "\n");
            }
        }
    }
}