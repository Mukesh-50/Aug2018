package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Helper;

public class LogOutPage {
	
	WebDriver driver;
	
	
	public LogOutPage(WebDriver ldriver) {
		
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//a[text()='Welcome Admin']") WebElement welcomeMessage;
	
	@FindBy(xpath="//a[text()='Logout']") WebElement logOutText;
	
	
	public void logoutFromApplication()
	{
		Helper.syncWebElement(driver, welcomeMessage).click();
		
		Helper.syncWebElement(driver, logOutText).click();
		
		Helper.waitForCurentURL(driver, "login");
	}
	

}
