package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaSearch {
	
	@FindBy(xpath="//input[@icon='search']")private WebElement search;
	@FindBy(xpath="//button[@class='button-green']")private WebElement add;
	@FindBy(xpath="//button[@class='button-blue']")private WebElement buy;
	@FindBy(xpath="//button[@class='button-orange']")private WebElement sell;
	@FindBy(xpath="//button[@data-balloon='Market depth widget']")private WebElement marketDepth;
	@FindBy(xpath="//span[@class='icon icon-trash']")private WebElement delete;
	@FindBy(xpath="//span[@class='icon icon-ellipsis']")private WebElement  more;
	@FindBy(xpath="//span[text()='Orders']")private WebElement  orders;
	
	public ZerodhaSearch(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSearch(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.click();
	}
	public void enterFullStockName(String stock)
	{
		search.sendKeys(stock);
	}
	public void enterFirstThreeWordsOfStock(String stock)
	{
		search.sendKeys(stock);
	}
	public void clickOnAddStock() {
		add.click();
	}
	public void clickOnBuyStock() {
		buy.click();
	}
	public void clickOnSellStock() {
		sell.click();
	}
	public void clickOnOrders(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(orders));
		orders.click();
	}
}
