package pages.supervisor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PatientManagement_ManagePrescriptionPage {

    WebDriver driver;

    public PatientManagement_ManagePrescriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    //Findby to find elements
    @FindBy(how = How.XPATH, using = "//button[@id='addBtn']")
    WebElement addPrescriptionButton;
    @FindBy(how = How.XPATH, using = "//select[@id='drugSelect']")
    WebElement drugSelectDropDown;
    @FindBy(how = How.XPATH, using = "//input[@id='isChronicTrueRadio']")
    WebElement longTermRadioButton;
    @FindBy(how = How.XPATH, using = "//input[@id='dosageInput']")
    WebElement dosageInputTextBox;
    @FindBy(how = How.XPATH, using = "//input[@id='frequencyPerDayInput']")
    WebElement frequencyPerDayInputTextBox;
    @FindBy(how = How.XPATH, using = "//input[@id='afterMealTrueRadio']")
    WebElement afterMealTrueRadioButton;
    @FindBy(how = How.XPATH, using = "//input[@id='instructionInput']")
    WebElement instructionInputTextBox;
    @FindBy(how = How.XPATH, using = "//input[@id='prescriptionRemarksInput']")
    WebElement prescriptionRemarksInputTextBox;
    @FindBy(how = How.XPATH, using = "//input[@id='startDateInput']")
    WebElement startDateInput;
    @FindBy(how = How.XPATH, using = "//input[@id='endDateInput']")
    WebElement endDateInput;
    @FindBy(how = How.XPATH, using = "//button[@id='submitBtn']")
    WebElement submitButton;


    public void clickOnAddPrescriptionButton() {
        addPrescriptionButton.sendKeys(Keys.RETURN);
    }

    public Select getDrugSelect() {
        return new Select(drugSelectDropDown);
    }

    public void dropDownChooseRole(String role) {
        getDrugSelect().selectByVisibleText(role);
    }

    public void clickOnLongTermRadioButton() {
        longTermRadioButton.click();
    }

    public void setDosage(String dosage) {
        dosageInputTextBox.sendKeys(dosage);
    }

    public void setFrequency(String ferquency) {
        frequencyPerDayInputTextBox.sendKeys(ferquency);
    }

    public void clickOnAfterMealTrueRadioButton() {
        afterMealTrueRadioButton.click();
    }

    public void setInstruction(String instruction) {
        instructionInputTextBox.sendKeys(instruction);
    }

    public void setRemark(String remark) {
        prescriptionRemarksInputTextBox.sendKeys(remark);
    }

    public void setStartDate(String date) {
        startDateInput.sendKeys(date);
    }

    public void setEndDate(String date) {
        endDateInput.sendKeys(date);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }
}
