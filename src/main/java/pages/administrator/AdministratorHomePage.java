package pages.administrator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdministratorHomePage {

    WebDriver driver;

    public AdministratorHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Findby to find elements
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Accounts')]")
    WebElement manageAccountsButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Register Account')]")
    WebElement registerAccountButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Roles')]")
    WebElement manageRolesButton;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Manage Centres')]")
    WebElement manageCentersButton;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Manage Lists')]")
    WebElement manageListsButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Edit Roles')]")
    WebElement editRoleButton;

    @FindBy(how = How.XPATH, using = "//a[@id='navbarDropdownMenuLink']")
    WebElement navbarDropDownButton;
    @FindBy(how = How.XPATH, using = "//a[@id='manage']")
    WebElement navbarDropDown_EditProfileButton;
    @FindBy(how = How.XPATH, using = "//a[@id='logout']")
    WebElement navbarDropDown_LogOutButton;


    public void clickOnManageAccountsButton() {
        manageAccountsButton.click();
    }

    public void clickOnRegisterAccountButton() {
        registerAccountButton.click();
    }

    public void clickOnManageRolesButton() {
        manageRolesButton.click();
    }

    public void clickOnManageCentersButton() {
        manageCentersButton.click();
    }

    public void clickOnManageListsButton() {
        manageListsButton.click();
    }

    public void clickOnEditRoleButtonButton() {
        editRoleButton.click();
    }

    public void clickOnNavbarDropDownButton() {
        navbarDropDownButton.click();
    }

    public void clickOnNavbarDropDown_EditProfileButton() {
        navbarDropDown_EditProfileButton.click();
    }

    public void clickOnNavbarDropDown_LogOutButton() {
        navbarDropDown_LogOutButton.click();
    }
}
