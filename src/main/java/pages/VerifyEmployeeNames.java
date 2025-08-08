package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

public class VerifyEmployeeNames {

	WebDriver driver;
	WebDriverWait wait;

	public VerifyEmployeeNames(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
	WebElement empNameInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@role='rowgroup']/div[@role='row']")
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
	List<WebElement> employeeRows;

	@FindBy(xpath = "//ul[@class='oxd-pagination__ul']/li")
	private List<WebElement> paginationItems;

	public boolean searchEmployeeAndVerify(String firstName, String lastName) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		while (true) {

			List<WebElement> employeeRows = driver
					.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']"));

			for (WebElement row : employeeRows) {
				String rowText = row.getText();
				if (rowText.contains(firstName) && rowText.contains(lastName)) {
					System.out.println("Name Verified: " + firstName + " " + lastName);

					return true;
				}
			}

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			try {
				WebElement nextBtn = driver.findElement(By.xpath(
						"//button[contains(@class,'oxd-pagination-page-item') and .//i[contains(@class,'bi-chevron-right')]]"));

				if (nextBtn.getAttribute("class").contains("disabled")) {
					break;
				}

				nextBtn.click();
				wait.until(ExpectedConditions.stalenessOf(employeeRows.get(0)));
			} catch (NoSuchElementException e) {
				break;
			}
		}

		return false;
	}

}
