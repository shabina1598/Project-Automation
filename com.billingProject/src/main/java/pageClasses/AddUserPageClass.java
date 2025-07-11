package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;
import utility.WaitUtilities;

public class AddUserPageClass {

	WebDriver driver;
	GeneralUtilities gUtil = new GeneralUtilities();
	WaitUtilities wUtil = new WaitUtilities();

	public AddUserPageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//label[text()='Prefix:']//following::input[@id='surname']")
	WebElement prefix;
	@FindBy(css = "#first_name")
	WebElement firstName;
	@FindBy(css = "#last_name")
	WebElement lastName;
	@FindBy(xpath = "//label[text()='Email:*']//following::input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//label[text()='Role:*']//following::span[text()='Admin']")
	WebElement role;
	@FindBy(xpath = "//label[text()='Password:*']//following::input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//label[text()='Confirm Password:*']//following::input[@id='confirm_password']")
	WebElement confirmPassword;
	@FindBy(css = "#submit_user_button")
	WebElement saveBtn;

	public void addUser(String pre_fix, String first_Name, String last_Name, String e_mail, int roleIndex,
			String pass_word, String confirm_Password) {
		prefix.sendKeys(pre_fix);
		firstName.sendKeys(first_Name);
		lastName.sendKeys(last_Name);
		email.sendKeys(e_mail);
		role.click();
		gUtil.pressArrowDown(driver, roleIndex);
		password.sendKeys(pass_word);
		confirmPassword.sendKeys(confirm_Password);
		wUtil.waitForElementToBeClickable(driver, 5, saveBtn);
		saveBtn.click();

	}

}
