package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import stepDefinition.Base;


public class quickChecks {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		Properties config = new Properties();
		config.load(fis);
		
		Properties oR = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\oR.properties");
		oR.load(fis);
		
		if(config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(config.getProperty("appUrl"));
			
		}else if(config.getProperty("browser").equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(config.getProperty("appUrl"));
		}
		
		driver.findElement(By.xpath(oR.getProperty("email_field"))).sendKeys("Dreadporticos@gmail.com");
		driver.findElement(By.xpath(oR.getProperty("pasword_field"))).sendKeys("Password@12");
		driver.findElement(By.xpath(oR.getProperty("signIn_button"))).click();

	}

}
