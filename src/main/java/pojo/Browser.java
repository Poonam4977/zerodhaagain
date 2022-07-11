package pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver chromeBrowser() throws InterruptedException
	{
		
		//System.setProperty("webdriver.chrome.driver","D:\\velocity softwares\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable notification----");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		return driver;
	}
}
