package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	@FindBy(css = "input[name='username']")
	WebElement usernameField;

	@FindBy(css = "input[type='password']")
	WebElement passwordField;

	@FindBy(css = "button[type='submit']")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys(username);

		passwordField.sendKeys(password);
		loginButton.click();
	}
}
