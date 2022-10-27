package org.andersen.lab.pages;

import org.andersen.lab.base.BasePage;
import org.andersen.lab.objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm extends BasePage {

    private final By firstNameFld = By.cssSelector("fieldset[class='fieldset'] input[name='name']");
    private final By lastNameFld = By.cssSelector("body > section:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > fieldset:nth-child(1) > p:nth-child(2) > input:nth-child(2)");
    private final By countryDropdown = By.cssSelector("body > section:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > form:nth-child(2) > fieldset:nth-child(4) > select:nth-child(2)");
    private final By phone = By.cssSelector("fieldset[class='fieldset'] input[name='phone']");
    private final By usernameFld = By.cssSelector("fieldset[class='fieldset'] input[name='username']");
    private final By email = By.cssSelector("fieldset[class='fieldset'] input[name='email']");
    private final By password = By.cssSelector("fieldset[class='fieldset'] input[name='password']");
    private final By confirmPassword = By.cssSelector("input[name='c_password']");
    private final By confirmPasswordLabel = By.cssSelector("label[for='c_password']");
    private final By submitBtn = By.cssSelector("input[value='submit']");
    private final By heading = By.cssSelector(".heading");
    private final By hobby = By.cssSelector("fieldset[class='fieldset padding-bottom'] label:nth-child(3)");



    public RegistrationForm(WebDriver driver) {
        super(driver);
    }

    public RegistrationForm setFirstNameFld(String firstName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld)).sendKeys(firstName);
        return this;
    }

    public RegistrationForm setLastNameFld(String lastName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFld)).sendKeys(lastName);
        return this;
    }

    public RegistrationForm setHobby(){
        driver.findElement(hobby).click();
        return this;
    }

    public RegistrationForm setCountry(String country){
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(countryDropdown)));
        select.selectByVisibleText(country);
        return this;
    }

    public RegistrationForm setPhoneNumber(String phoneNumber){
        wait.until(ExpectedConditions.visibilityOfElementLocated(phone)).sendKeys(phoneNumber);
        return this;
    }

    public RegistrationForm setUsername(String userName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld)).sendKeys(userName);
        return this;
    }

    public RegistrationForm setEmail(String userEmail){
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(userEmail);
        return this;
    }
    public RegistrationForm setPassword(String userPassword){
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(userPassword);
        return this;
    }

    public RegistrationForm confirmPassword(String userPassword){
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).sendKeys(userPassword);
        return this;
    }


    public RegistrationForm fillTheFormCorrectly(User user){
        return  setFirstNameFld(user.getFirstName()).
                setLastNameFld(user.getLastName()).
                setHobby().
                setCountry(user.getCountry()).
                setPhoneNumber(user.getPhoneNumber()).
                setEmail(user.getEmail()).
                setUsername(user.getUsername()).
                setPassword(user.getPassword()).
                confirmPassword(user.getPassword());
    }

    public RegistrationForm fillTheFormWithoutPasswordConfirmation(User user){
        return  setFirstNameFld(user.getFirstName()).
                setLastNameFld(user.getLastName()).
                setCountry(user.getCountry()).
                setPhoneNumber(user.getPhoneNumber()).
                setEmail(user.getEmail()).
                setUsername(user.getUsername()).
                setPassword(user.getPassword());
    }



    public RegistrationForm submitForm() {
        driver.findElement(submitBtn).click();
        return this;
    }

    public RegistrationForm load(){
        load("way2auto_jquery/registration.php#load_box");
        return this;
    }

    public String getHeading() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(heading)).getText();
    }

    public String getConfirmPasswordLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordLabel)).getText();
    }

}
