package testCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import factory.DataProviderFactory;
import pages.LoginPage;
import utility.BaseClass;

public class LoginTest extends BaseClass {

	@Test(enabled = false)
	public void loginWithValidUser() {

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginData", 0, 0),
				DataProviderFactory.getExcel().getStringData("LoginData", 0, 1));

	}

	@Test()
	public void loginWithValidUserWithReport() throws IOException {

		logger = extentReport.createTest("LoginCRM", "This test will login to CRM with valid credentials");

		logger.log(Status.INFO, "Trying to login in CRM");

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginData", 0, 0),
				DataProviderFactory.getExcel().getStringData("LoginData", 0, 1));
			
	}

}
