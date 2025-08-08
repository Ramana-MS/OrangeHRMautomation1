package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver driver;

	@FindBy(css = ".oxd-text.oxd-text--h6")
	WebElement verifyofDashboard;

	// FIXED: Corrected locator for PIM menu
	@FindBy(xpath = "//span[text()='PIM']/ancestor::a")
	WebElement PIMmenu;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getDashboardHeading() {
		return verifyofDashboard.getText();
	}

	// Use proper wait and click
	public void hoverAndclickOnPIM() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(PIMmenu));

		Actions actions = new Actions(driver);
		actions.moveToElement(PIMmenu).click().build().perform();
	}
}
