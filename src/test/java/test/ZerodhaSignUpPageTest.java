package test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaSignUpPage;

public class ZerodhaSignUpPageTest {
	WebDriver driver;
	ZerodhaSignUpPage zerodhaSignUpPage=new ZerodhaSignUpPage(driver);
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException
	{
		driver=Browser.chromeBrowser();
	}
	@Test
	
	public void signUpTest()
	{
		ZerodhaSignUpPage zerodhaSignUpPage=new ZerodhaSignUpPage(driver);
		zerodhaSignUpPage.clickOnSignUp();
		zerodhaSignUpPage.openSignUpPage(1, driver);
		zerodhaSignUpPage.enterMobileNumber("8888148293");
		
	}

}
