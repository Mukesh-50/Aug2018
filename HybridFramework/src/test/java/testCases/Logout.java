package testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import factory.DataProviderFactory;
import pages.LogOutPage;
import pages.LoginPage;
import utility.BaseClass;

public class Logout extends BaseClass {

	
	LoginPage login;
	
	LogOutPage logout;
	
	@Test
	public void loginWithValidUserWithReport() throws IOException {

		logger = extentReport.createTest("LoginCRM", "This test will login to CRM with valid credentials");

		logger.log(Status.INFO, "Trying to login in CRM");

		login = PageFactory.initElements(driver, LoginPage.class);
		
		login.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginData", 0, 0),
				DataProviderFactory.getExcel().getStringData("LoginData", 0, 1));
		
	}
	
	
	@Test(dependsOnMethods="loginWithValidUserWithReport")
	public void logOutFromApplication()
	{
		logger = extentReport.createTest("Logout CRM", "This test will logout from application");
		
		logout = PageFactory.initElements(driver, LogOutPage.class);
		
		logout.logoutFromApplication();
		
		logger.log(Status.PASS, "Logout from Application");
		
	}
	

}
