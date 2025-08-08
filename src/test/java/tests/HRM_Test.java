package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.PIM_Page;
import pages.VerifyEmployeeNames;
import utils.BasePage;

public class HRM_Test extends BasePage {

	LoginPage loginpage;
	DashboardPage dashboardPage;
	PIM_Page pimPage;
	VerifyEmployeeNames employeeNames;

	@Test
	public void verifyAllTest() throws InterruptedException {
		// login with user credentials
		loginpage = new LoginPage(driver);
		loginpage.login("Admin", "admin123");

		// verifydashboard appeareance
		dashboardPage = new DashboardPage(driver);
		String heading = dashboardPage.getDashboardHeading();
		Assert.assertEquals(heading, "Dashboard");

		// mousehover and click on PIM
		dashboardPage.hoverAndclickOnPIM();

		// addEmployee's
		pimPage = new PIM_Page(driver);
		String PIMtext = pimPage.getPIMHeading();
		Assert.assertEquals(PIMtext, "PIM");

		pimPage.addEmployeeList("He", "Man");
		pimPage.addEmployeeList("Jackie", "Chan");
		pimPage.addEmployeeList("Naruto", "Uzumaki");
		pimPage.addEmployeeList("Venkatesh", "Ramana");
		pimPage.navigateToEmployeeList();

		// verify the employee names by searching on employeeList
		VerifyEmployeeNames employeeNames = new VerifyEmployeeNames(driver);

		boolean isHeManPresent = employeeNames.searchEmployeeAndVerify("He", "Man");
		Assert.assertTrue(isHeManPresent, "Employee 'He Man'not found in table.");

		boolean isJackiePresent = employeeNames.searchEmployeeAndVerify("Jackie", "Chan");
		Assert.assertTrue(isJackiePresent, "Employee 'Jackie' not found in table.");

		boolean isNarutoPresent = employeeNames.searchEmployeeAndVerify("Naruto", "Uzumaki");
		Assert.assertTrue(isNarutoPresent, "Employee 'Naruto Uzumaki'  not found in table.");

		boolean isRamPresent = employeeNames.searchEmployeeAndVerify("Venkatesh", "Ramana");
		Assert.assertTrue(isRamPresent, "Employee 'Ram'not found in table.");

	}

}