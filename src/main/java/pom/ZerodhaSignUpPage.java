package pom;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaSignUpPage {
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement SignUp;
	@FindBy(xpath="//input[@id='user_mobile']")private WebElement mobileNo;
	@FindBy(xpath="//button[@id='open_account_proceed_form']")private WebElement submit;
	
	public ZerodhaSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openSignUpPage(int indexNo,WebDriver driver)
	{
		ArrayList<String>list=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(indexNo));
	}
	public void clickOnSignUp()
	{
		SignUp.click();
	}
	public void enterMobileNumber(String mobileNumber)
	{
		mobileNo.sendKeys(mobileNumber);
	}
	public void clickOnContinue()
	{
		submit.click();
	}
}
