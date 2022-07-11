package test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.ZerodhaLoginPage;
import utility.Excel;
import utility.ScreenShot;

public class ZerodhaLoginPageTest {
	WebDriver driver;
	@BeforeMethod
	public void openBrowser() throws InterruptedException
	{
		driver=Browser.chromeBrowser();
	}
	@AfterMethod
	public void takeScreenshots() throws IOException
	{
		ScreenShot.screenshott(driver,"zerodhatest");
	}
	
	@Test
	public void loginTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		ZerodhaLoginPage zerodhaLoginPage=new ZerodhaLoginPage(driver);
		boolean status =zerodhaLoginPage.isImageDisplayed();
		//Assert.assertFalse(status);//hard Assert
		SoftAssert softAssert=new SoftAssert();
		//softAssert.assertFalse(status);
		String userId=Excel.getData("FETCH", 0, 1);
		String pass=Excel.getData("FETCH", 1, 1);
		String pin=Excel.getData("FETCH", 2, 1);
		zerodhaLoginPage.enterUserId(userId);
		zerodhaLoginPage.enterPassword(pass);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(3000);
		zerodhaLoginPage.enterPin(pin,driver);
		zerodhaLoginPage.clickOnContinue();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.titleContains("Dashboard / Kite"));
		String currentTitle=driver.getTitle();
		String expectedTitle="Dashboard / Kite";
		Assert.assertEquals(currentTitle, expectedTitle);
		softAssert.assertEquals(currentTitle, expectedTitle);
		softAssert.assertAll();
	}

}
