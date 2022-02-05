package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Findby to find elements
    @FindBy(how=How.XPATH, using="//a[contains(text(),'Create Role')]") WebElement createRoleButton;

    @FindBy(how=How.XPATH, using="//input[@id='Input_FirstName']") WebElement firstNameTextBox;
    @FindBy(how=How.XPATH, using="//input[@id='Input_LastName']") WebElement lastNameTextBox;
    @FindBy(how=How.XPATH, using="//input[@id='Input_PreferedName']") WebElement preferedNameTextBox;
    @FindBy(how=How.XPATH, using="//select[@id='Input_Gender']") WebElement genderDropdown;
    @FindBy(how=How.XPATH, using="//input[@id='Input_DOB']") WebElement dateOfBirthTextBox;
    @FindBy(how=How.XPATH, using="//input[@id='Input_NRIC']") WebElement NRICTextBox;
    @FindBy(how=How.XPATH, using="//input[@id='Input_Address']") WebElement addressTextBox;
    @FindBy(how=How.XPATH, using="//input[@id='Input_Email']") WebElement emailTextBox;
    @FindBy(how=How.XPATH, using="//input[@id='Input_Username']") WebElement usernameTextBox;
    @FindBy(how=How.XPATH, using="//input[@id='Input_Password']") WebElement passwordTextBox;
    @FindBy(how=How.XPATH, using="//input[@id='Input_ConfirmPassword']") WebElement confirmPasswordTextBox;
    @FindBy(how=How.XPATH, using="//body/div[3]/div[1]/div[1]/form[1]/div[5]/div[2]/div[1]/input[1]") WebElement registerButton;

    @FindBy(how=How.XPATH, using="//select[@id='Input_RoleId']") WebElement roleDropdown;

    public void setFirstName(String firstname) {
        firstNameTextBox.sendKeys(firstname);
    }
    public void setLastName(String lastname) {
        lastNameTextBox.sendKeys(lastname);
    }
    public void setPreferedName(String preferedname) {
        preferedNameTextBox.sendKeys(preferedname);
    }

    public Select getGenderSelect() {
        return new Select(genderDropdown);
    }
    public void DropDownChooseGender(String gender) {
        getGenderSelect().selectByVisibleText(gender);
    }

    public void setDateOfBirth(String dateOfBirth) {
        dateOfBirthTextBox.sendKeys(dateOfBirth);
    }
    public void setNRIC(String NRIC) {
        NRICTextBox.sendKeys(NRIC);
    }
    public void setAddress(String address) {
        addressTextBox.sendKeys(address);
    }
    public void setEmail(String email) {
        emailTextBox.sendKeys(email);
    }
    public void setUsername(String username) {
        usernameTextBox.sendKeys(username);
    }
    public void setPassword(String password) {
        passwordTextBox.sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword) {
        confirmPasswordTextBox.sendKeys(confirmPassword);
    }

    public Select getRoleSelect() {
        return new Select(roleDropdown);
    }
    public void dropDownChooseRole(String role) {
        getRoleSelect().selectByVisibleText(role);
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

}
