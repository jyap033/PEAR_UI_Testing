package pages.supervisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PatientManagement_MoreDetailPage {
    WebDriver driver;

    public PatientManagement_MoreDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    //Findby to find elements
    @FindBy(how = How.XPATH, using = "//input[@id='firstNameInput']")
    WebElement firstNameTextBox;
    @FindBy(how = How.XPATH, using = "//input[@id='lastNameInput']")
    WebElement lastNameTextBox;
    @FindBy(how = How.XPATH, using = "//a[@id='prescriptionNav']")
    WebElement managePrescriptionButton;
    public String getFirstNameTextBoxValue() {
        return firstNameTextBox.getAttribute("value");
    }

    public String getLastNameTextBoxValue() {
        return lastNameTextBox.getAttribute("value");
    }

    public void clickOnManagePrescriptionButton() {
        managePrescriptionButton.click();
    }


}
