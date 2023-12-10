package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import stepDefinition.Base;

public class Utils extends Base {
	public static WebDriver driver = Base.getDriver();
	
public void captureScreenshot() throws IOException {
		
		Date d = new Date();
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_");
//		call take screenshot function
		takeSnapshot(driver, "F:\\Users\\Bluechip\\eclipse-workspace\\KPMG_CnB\\target\\screenshot\\screenshot"+screenshotName+".jpg" );
	}
	
	
	
	public static void takeSnapshot(WebDriver driver, String FileWithPath) throws IOException {
		
		//Call getScreenshotAs method to create image file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//Move image file to new destination
		File destFile = new File(FileWithPath);
		
		//Copy file at destination
		FileUtils.copyFile(scrFile, destFile);
	}


}
