package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIM_Page {
	private WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//h6[text()='PIM']")
	WebElement verifyPIMPage;

	@FindBy(xpath = "//a[text()='Add Employee']")
	WebElement addEmployee;
	@FindBy(css = "input[name='firstName']")
	WebElement firstName;
	@FindBy(css = "input[name='lastName']")
	WebElement lastName;
	@FindBy(css = "button[type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//a[text()='Employee List']")
	WebElement employeeList;

	public PIM_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPIMHeading() {
		return verifyPIMPage.getText();

	}

	public void addEmployeeList(String fName, String lName) throws InterruptedException {
		addEmployee.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(firstName));

		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		saveBtn.click();

	}

	public void navigateToEmployeeList() {
		wait.until(ExpectedConditions.elementToBeClickable(employeeList)).click();
	}

}
