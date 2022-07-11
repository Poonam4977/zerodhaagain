package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import pojo.Browser;

public class ScreenShot {
	public static void screenshott(WebDriver driver,String name) throws IOException
	{
		String d=ScreenShot.date();
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("D:\\screenshot\\"+name+ d+".jpeg");
		FileHandler.copy(source, destination);
	}
	public static String date() {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY-MM-dd-HH-mm-ss");
		LocalDateTime cur=LocalDateTime.now();
		String d=dtf.format(cur);
		return d;
		
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=Browser.chromeBrowser();
		ScreenShot.screenshott(driver, "nw" );
		
	}
}
