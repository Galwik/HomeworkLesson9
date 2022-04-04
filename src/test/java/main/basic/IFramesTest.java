package main.basic;

import driver.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class IFramesTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(IFramesTest.class);
    private static final String path = "https://seleniumui.moderntester.pl/iframes.php";

    @Test
    void iFramesTest() {
        driver.get(path);
        driver.switchTo().frame("iframe1");
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Kamil");
        driver.findElement(By.cssSelector("#inputSurname3")).sendKeys("Gawlicki");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("iframe2");
        driver.findElement(By.cssSelector("#inputLogin")).sendKeys("Kamil");
        driver.findElement(By.cssSelector("#inputPassword")).sendKeys("qwerty");
        List<WebElement> continents = driver.findElements(By.cssSelector(".custom-select [value]"));
        continents.get(new Random().nextInt(continents.size())).click();
        List<WebElement> yearsOfExperience = driver.findElements(By.cssSelector("[name='gridRadios']"));
        yearsOfExperience.get(new Random().nextInt(yearsOfExperience.size())).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector(".navbar-nav li:first-child")).click();
        log.info(">>>>>  IFrames Test");
    }
}