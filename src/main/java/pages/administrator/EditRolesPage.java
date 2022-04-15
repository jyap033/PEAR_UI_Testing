package pages.administrator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditRolesPage {

    WebDriver driver;

    public EditRolesPage(WebDriver driver) {
        this.driver = driver;
    }

    //Findby to find elements
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Create Role')]")
    WebElement createRoleButton;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Create Role')]")
    WebElement confirmCreateRoleButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(how = How.XPATH, using = "//input[@id='RoleName']")
    WebElement roleNameTextBox;

    public void setRoleName(String rolename) {
        roleNameTextBox.sendKeys(rolename);
    }

    public void clickOnCreateRoleButton() {
        createRoleButton.click();
    }

    public void clickOnConfirmCreateRoleButton() {
        confirmCreateRoleButton.click();
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }


}
