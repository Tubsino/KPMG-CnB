package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginValidation {
	
	public static WebDriver driver = Base.getDriver();
	SoftAssert softassert;
	WebDriverWait wait;
	
	
	@Given("that admin is on login page")
	public void that_admin_is_on_login_page() {
		driver.navigate().refresh();
		softassert = new SoftAssert();
		String expectedTxt = "Log In";
		String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("login_txt"))).getText();
	    System.out.println("Admin on login page");
	    softassert.assertEquals(actualTxt, expectedTxt);
	    softassert.assertAll();
	}

	@When("admin input email address in the email field")
	public void admin_input_email_address_in_the_email_field() {
		driver.findElement(By.xpath(Base.oR.getProperty("email_field"))).sendKeys("testme");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("Admin enters email");
	}

	@And("input password in the password field")
	public void input_password_in_the_password_field() {
		driver.findElement(By.xpath(Base.oR.getProperty("pasword_field"))).sendKeys("P@ssw0rd");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("Admin enters password");
	}
	
	@And("click on the sign in button")
	public void click_on_the_sign_in_button() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("login_txt"))));
		driver.findElement(By.xpath(Base.oR.getProperty("signIn_button"))).click();
		System.out.println("Admin click on sign in");
	}

	@Then("it should not be successful")
	public void it_should_not_be_successful() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath(Base.oR.getProperty("unsuccessfulSignIn_txt"))));
//		wait.until(ExpectedConditions.alertIsPresent());
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String expectedTxt = "Login failed. Please try again later.";
		String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("unsuccessfulSignIn_txt"))).getText();
		softassert.assertEquals(actualTxt, expectedTxt);
		softassert.assertAll();
//		driver.navigate().refresh();
		System.out.println("invalid login not successful");
		
	}

	@When("admin input a valid email address in the email field")
	public void admin_input_a_valid_email_address_in_the_email_field() {
		driver.findElement(By.xpath(Base.oR.getProperty("email_field"))).sendKeys("Dreadporticos@gmail.com");
		System.out.println("1");
	}

	@And("input a valid password in the password field")
	public void input_a_valid_password_in_the_password_field() {
		driver.findElement(By.xpath(Base.oR.getProperty("pasword_field"))).sendKeys("Password@12");
		System.out.println("2");
	}

	@Then("it should be successful")
	public void it_should_be_successful() {
		System.out.println("3");
	}


}
