package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.GeneralUtilities;
import utility.WaitUtilities;

public class LoginPageClass {

	WebDriver driver;
	GeneralUtilities gUtil = new GeneralUtilities();
	WaitUtilities wwUtil = new WaitUtilities();

	public LoginPageClass(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	WebElement username;
	@FindBy(css = "#password")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	@FindBy(xpath = "//span[@class='help-block']//strong[contains(text(),'do not match our records.')]")
	WebElement loginErrorMsg;

	public void login(String u_name, String p_word) {
		username.sendKeys(u_name);
		password.sendKeys(p_word);
		loginBtn.click();

	}
	
	public String getTextOfLoginErrorMsg() {
		
		return gUtil.getTextOfElement(loginErrorMsg);
	}

}
