package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper {

	public static WebElement waitForWebElement(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;

	}
	
	
	public static WebElement syncWebElement(WebDriver driver,WebElement element)
	{
		
		waitForWebElement(driver, element);
		highLightElement(driver, element);
		
		return element;
	}
	

	public static void highLightElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

	public static void waitForTitleContains(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.titleContains(title)));
	}

	public static void waitForTitleExact(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs(title)));
	}

	public static void waitForCurentURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Assert.assertTrue(wait.until(ExpectedConditions.urlContains(url)));
	}

	public void acceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	public void dismissAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		;
	}

	public static String getScreenshot(WebDriver driver) {
		String path = System.getProperty("user.dir") + "/Screenshots/" + Helper.getSystemDate() + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshots " + e.getMessage());
		}

		return path;

	}

	public static String getSystemDate() {

		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");

		Date date = new Date();

		return dateFormat.format(date);

	}

	public static String getScreenshot(WebDriver driver, String nameOfScreenShot) {
		String path = System.getProperty("user.dir") + "/Screenshots" + nameOfScreenShot + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture screenshots " + e.getMessage());
		}

		return path;

	}
}
