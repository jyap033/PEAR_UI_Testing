package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Findby to find elements
    @FindBy(how = How.XPATH, using = "//input[@id='Input_Email']")
    WebElement emailTextBox;
    @FindBy(how = How.NAME, using = "Input.Role")
    WebElement roleDropdown;
    @FindBy(how = How.XPATH, using = "//input[@id='Input_Password']")
    WebElement passwordTextBox;
    @FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/input[1]")
    WebElement loginButton;

    public void setEmail(String username) {
        emailTextBox.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public Select getRoleSelect() {
        return new Select(roleDropdown);
    }

    public void dropDownChooseRole(String role) {
        getRoleSelect().selectByVisibleText(role);
    }
}
