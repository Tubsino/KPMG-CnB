package stepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static FileInputStream fis;
	public static WebDriver driver;
	public static Properties config;
	public static Properties oR;
	public static Properties assertions;
	public static Properties data;
	
	@BeforeAll
	public static void setup() throws FileNotFoundException, IOException {
	
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
				Properties config = new Properties();
				config.load(fis);
				
				oR = new Properties();
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\oR.properties");
				oR.load(fis);
				
				assertions = new Properties();
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\assertions.properties");
				oR.load(fis);
				
				data = new Properties();
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\data.properties");
				oR.load(fis);

		
		if(config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(config.getProperty("appUrl"));
			
		} else if(config.getProperty("browser").equals("fireFox")) {
			WebDriverManager.firefoxdriver().setup();;
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(config.getProperty("appUrl"));
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
//	@AfterAll
//	public static void tearDown(){
//		driver.close();
//	}
	

}
