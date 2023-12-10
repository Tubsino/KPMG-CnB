package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class JobGradeValidation {
	public static WebDriver driver = Base.getDriver();
	WebDriverWait wait;
	SoftAssert softassert;
	
	@When("Super Admin clicks on the job grade module  button")
	public void super_admin_clicks_on_the_job_grade_module_button() {
	  wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("job_grade_btn"))));
	  driver.findElement(By.xpath(Base.oR.getProperty("job_grade_btn"))).click();
	}
	@Then("job grade page should display successfully")
	public void job_grade_page_should_display_successfully() {
	    wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("genGrade_btn"))));
	    softassert = new SoftAssert();
	    String expGradeTxt = "Generic Grades";
	    String actGradeTxt = driver.findElement(By.xpath(Base.oR.getProperty("genGrade_btn"))).getText();
	    softassert.assertEquals(expGradeTxt, actGradeTxt);
	    
	    String matchQesTxt = "Matching Questions";
	    String actMatchQesTxt = driver.findElement(By.xpath(Base.oR.getProperty("matchQest_btn"))).getText();
	    softassert.assertEquals(matchQesTxt, actMatchQesTxt);
	    softassert.assertAll();
	    
	}

}
