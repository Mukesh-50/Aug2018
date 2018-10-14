package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.Helper;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(how=How.ID,using="txtUsername")WebElement uname;
	@FindBy(how = How.NAME, using = "txtPassword") WebElement pass;
	@FindBy(how=How.XPATH,using="//input[@value='LOGIN']") WebElement loginButton;
	
	
	public void loginToApplication(String username,String password)
	{
		uname.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
		System.out.println("Username and Password Entered");
		Helper.waitForCurentURL(driver, "dashboard");
	}
		
}
