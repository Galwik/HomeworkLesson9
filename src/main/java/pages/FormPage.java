package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstName;

    @FindBy(id = "inputLastName3")
    private WebElement lastName;

    @FindBy(id = "inputEmail3")
    private WebElement email;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> genders;

    @FindBy(id = "inputAge3")
    private WebElement age;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperience;

    @FindBy(id = "gridCheckAutomationTester")
    private WebElement profession;

    @FindBy(css = "#selectContinents :not([value=''])")
    private List<WebElement> continents;

    @FindBy(css = "[value='switch-commands']")
    private WebElement seleniumSwitchCommand;

    @FindBy(css = "[value='wait-commands']")
    private WebElement seleniumWaitCommand;

    @FindBy(id = "chooseFile")
    private WebElement fileUploader;

    @FindBy(className = "btn-primary")
    private WebElement signInButton;


    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setRandomSex() {
        this.genders.get(new Random().nextInt(genders.size())).click();
    }

    public void setAge(String age) {
        this.age.clear();
        this.age.sendKeys(age);
    }

    public void setRandomYearsOfExperience() {
        this.yearsOfExperience.get(new Random().nextInt(yearsOfExperience.size())).click();
    }

    public void setProfessionToAutomationTester() {
        this.profession.click();
    }

    public void setRandomContinent() {
        this.continents.get(new Random().nextInt(continents.size())).click();
    }

    public void setSwitchAndWaitSeleniumCommand(WebDriver driver) {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).click(seleniumSwitchCommand).click(seleniumWaitCommand).build().perform();
    }

    public void uploadFile(String path) {
        File fileToUpload = new File(path);
        this.fileUploader.sendKeys(fileToUpload.getAbsolutePath());
    }

    public void signIn() {
        signInButton.click();
    }


}