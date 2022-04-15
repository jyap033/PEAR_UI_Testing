package pages.supervisor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.concurrent.TimeUnit;

public class PatientManagementPage {
    WebDriver driver;

    public PatientManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    //Findby to find elements
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Inactive Patients')]")
    WebElement inactivePatientButton;
    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[8]/button[1]")
    WebElement aliceMoreDetailButton;
    @FindBy(how = How.XPATH, using = "//button[@id='unmaskGuardianBtn']")
    WebElement unmaskGuardianButton;

    public void clickOnInactivePatientButton() {
        inactivePatientButton.click();
    }

    public void clickOnAliceMoreDetailButton() {
        System.out.println(aliceMoreDetailButton.getLocation());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        aliceMoreDetailButton.sendKeys(Keys.RETURN);
    }

    public void clickOnUnmaskGuardianButton() {
        unmaskGuardianButton.click();
    }

}
