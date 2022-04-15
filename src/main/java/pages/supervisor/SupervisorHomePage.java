package pages.supervisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SupervisorHomePage {
    WebDriver driver;

    public SupervisorHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Findby to find elements
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'View Patient')]")
    WebElement viewPatientButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Preferences')]")
    WebElement managePreferencesButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'View Medication Schedule')]")
    WebElement viewMedicationScheduleButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Activities')]")
    WebElement manageActivitiesButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Attendance')]")
    WebElement manageAttendanceButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Adhoc')]")
    WebElement manageAdhocButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Generate Schedule')]")
    WebElement generateScheduleButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Export Schedule')]")
    WebElement exportScheduleButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'View Highlights')]")
    WebElement viewHighlightButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage Approval Requests')]")
    WebElement manageApprovalRequestsButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'View Activity Logs')]")
    WebElement viewActivityLogsButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'View Privacy Settings')]")
    WebElement viewPrivacySettingsButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Manage List Items')]")
    WebElement manageListItemsButton;

    @FindBy(how = How.XPATH, using = "//a[@id='navbarDropdownMenuLink']")
    WebElement navbarDropDownButton;
    @FindBy(how = How.XPATH, using = "//a[@id='manage']")
    WebElement navbarDropDown_EditProfileButton;
    @FindBy(how = How.XPATH, using = "//a[@id='logout']")
    WebElement navbarDropDown_LogOutButton;


    public void clickOnViewPatientButton() {
        viewPatientButton.click();
    }

    public void clickOnManagePreferencesButton() {
        managePreferencesButton.click();
    }

    public void clickOnMiewMedicationScheduleButton() {
        viewMedicationScheduleButton.click();
    }

    public void clickOnManageActivitiesButton() {
        manageActivitiesButton.click();
    }

    public void clickOnManageAttendanceButton() {
        manageAttendanceButton.click();
    }

    public void clickOnManageAdhocButton() {
        manageAdhocButton.click();
    }

    public void clickOnGenerateScheduleButton() {
        generateScheduleButton.click();
    }

    public void clickOnExportScheduleButton() {
        exportScheduleButton.click();
    }

    public void clickOnViewHighlightButton() {
        viewHighlightButton.click();
    }

    public void clickOnManageApprovalRequestsButton() {
        manageApprovalRequestsButton.click();
    }

    public void clickOnViewActivityLogsButton() {
        viewActivityLogsButton.click();
    }

    public void clickOnViewPrivacySettingsButton() {
        viewPrivacySettingsButton.click();
    }

    public void clickOnManageListItemsButton() {
        manageListItemsButton.click();
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
