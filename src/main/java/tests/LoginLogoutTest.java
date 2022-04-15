package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.administrator.AdministratorHomePage;
import pages.LoginPage;


public class LoginLogoutTest extends TestBase{
	@Test(dataProvider = "getData")
	public void init(String email, String password, String role, String expectedTitle) throws Exception{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.setEmail(email);
		loginpage.setPassword(password);
		loginpage.dropDownChooseRole(role);
		loginpage.clickOnLoginButton();
		String curr_window_title = driver.getTitle();
		try{
			Assert.assertEquals(curr_window_title, expectedTitle);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		//Logout
		AdministratorHomePage administratorHomePage = PageFactory.initElements(driver, AdministratorHomePage.class);
		administratorHomePage.clickOnNavbarDropDownButton();
		administratorHomePage.clickOnNavbarDropDown_LogOutButton();
	}

	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[5][4];

		data[0][0] = "janice@gmail.com";
		data[0][1] = "Admin!23";
		data[0][2] = "Administrator";
		data[0][3] ="Manage Accounts - PEAR";

		data[1][0] = "daniel@gmail.com";
		data[1][1] = "Doctor!23";
		data[1][2] = "Doctor";
		data[1][3] = "Patient Management - PEAR";

		data[2][0] = "tpg1@gmail.com";
		data[2][1] = "Guardian!23";
		data[2][2] = "Guardian";
		data[2][3] = "Manage Patients - PEAR";
		data[3][0] = "alan@gmail.com";
		data[3][1] = "Game!23";
		data[3][2] = "Game Therapist";
		data[3][3] = "Game Therapist Dashboard - PEAR";

		data[4][0] = "jess@gmail.com";
		data[4][1] = "Supervisor!23";
		data[4][2] = "Supervisor";
		data[4][3] = "Patient's Highlights - PEAR";

		return data;

	}
}
