package stepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AdminSurveyCreation {
	public static WebDriver driver = Base.getDriver();
	SoftAssert softassert;
	WebDriverWait wait;
	Select sel;

@Given("that admin is logged in")
public void that_admin_is_logged_in() {
	driver.findElement(By.xpath(Base.oR.getProperty("email1_field"))).sendKeys("Dreadporticos@gmail.com");
	driver.findElement(By.xpath(Base.oR.getProperty("pasword_field"))).sendKeys("Password@12");
	driver.findElement(By.xpath(Base.oR.getProperty("signIn_button"))).click();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
}

@When("super admin clicks on the survey button from the dashboard")
public void super_admin_clicks_on_the_survey_button_from_the_dashboard() {
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("createSurveyDash"))));
	
	softassert = new SoftAssert();
	String expectedTxt = "Create a Survey";
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("createSurveyDash"))));
	String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("createSurveyDash"))).getText();
	driver.findElement(By.xpath(Base.oR.getProperty("createSurveyDash"))).click();
	
//	String expectedAOD = "Age of Data";
//	String actualAOD = driver.findElement(By.xpath(Base.oR.getProperty("ageOfData_txt"))).getText();
//	
//	String expectTID = "Target Industry (s)";
//	String actualTID = driver.findElement(By.xpath(Base.oR.getProperty("tarInd_txt"))).getText();
//	System.out.println(driver.findElement(By.xpath(Base.oR.getProperty("createSurveyDash"))).getText());
//	
//	String expectedCtry = "Country";
//	String actualCtry = driver.findElement(By.xpath(Base.oR.getProperty("currency_txt"))).getText();
//	
//	String expCurr = "Currency";
//	String actCurr = driver.findElement(By.xpath(Base.oR.getProperty("currency_txt"))).getText();
//	
//	String expectedSurvSpon = "Survey Sponsor";
//	String actualSurvSpon = driver.findElement(By.xpath(Base.oR.getProperty("surSpon_txt"))).getText();
//	
//	softassert.assertEquals(actualSurvSpon, expectedSurvSpon);
	softassert.assertEquals(actualTxt, expectedTxt);
//	softassert.assertEquals(actualAOD, expectedAOD);
//	softassert.assertEquals(actualTID, expectTID);
//	softassert.assertEquals(actualCtry, expectedCtry);
//	softassert.assertEquals(actCurr, expCurr);
	softassert.assertAll();
	
}

@And("Input title of survey in the survey field")
public void input_title_of_survey_in_the_survey_field() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    driver.findElement(By.xpath(Base.oR.getProperty("titleOfSurvery_fld"))).sendKeys("Survey Test1");
}

@And("Input age of data in the the age of data field")
public void input_age_of_data_in_the_the_age_of_data_field() {
	driver.findElement(By.xpath(Base.oR.getProperty("ageOfData_fld"))).sendKeys("3");
}

@And("select target of industry dropdown")
public void select_target_of_industry_dropdown() {
	WebElement tInd = driver.findElement(By.xpath(Base.oR.getProperty("targetIndustry_fld")));
	sel = new Select(tInd);

	sel.selectByValue("2");
	
	
}

@And("select multiple target from the dropdown list")
public void select_multiple_target_from_the_dropdown_list() {
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,500)");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}

@And("click on the country field")
public void click_on_the_country_field() {
	WebElement country = driver.findElement(By.xpath(Base.oR.getProperty("country_fld")));
	sel = new Select(country);
	sel.selectByValue("1");
}

@And("select a country from the list of the dropdown menu for country")
public void select_a_country_from_the_list_of_the_dropdown_menu_for_country() {
	try {
		Thread.sleep(Duration.ofSeconds(3));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("curr_fld"))));
	WebElement currency = driver.findElement(By.xpath(Base.oR.getProperty("curr_fld")));
	sel = new Select(currency);
//	sel.selectByVisibleText("Nigeria");
	sel.selectByValue("1");
}

@And("click on the sponsor field")
public void click_on_the_sponsor_field() {
	WebElement SurvSpons = driver.findElement(By.xpath(Base.oR.getProperty("surSpon_fld")));
	sel = new Select(SurvSpons);
	sel.selectByValue("1");
}

@And("select a sponsor")
public void select_a_sponsor() {
    System.out.println("Sponsor selected");
}

@Then("click on the continue button")
public void click_on_the_continue_button() {
    driver.findElement(By.xpath(Base.oR.getProperty("cont_btn"))).click();
}

@And("select multiple job grades")
public void select_multiple_job_grades() {
    driver.findElement(By.xpath(Base.oR.getProperty("jobGrade_btn"))).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    driver.findElement(By.xpath(Base.oR.getProperty("jb_level_band2"))).click();
    driver.findElement(By.xpath(Base.oR.getProperty("jb_level_band3"))).click();
}
@And("click the save button")
public void click_the_save_button() {
	driver.findElement(By.xpath(Base.oR.getProperty("save_btn"))).click();
}
@And("click the continue button")
public void click_the_continue_button() {
	driver.findElement(By.xpath(Base.oR.getProperty("cont_btn"))).click();
}
@And("select multiple companies for comparism")
public void select_multiple_companies_for_comparism() {
	wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("MM_company_btn"))));
	driver.findElement(By.xpath(Base.oR.getProperty("MM_company_btn"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("ss_company_btn"))));
	driver.findElement(By.xpath(Base.oR.getProperty("ss_company_btn"))).click();
}
@And("click the continu button for completion")
public void click_the_continu_button_for_completion() {
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,500)");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.findElement(By.xpath(Base.oR.getProperty("cnt1_btn"))).click();
	
}
@And("click the submit button")
public void click_the_submit_button() {
	driver.findElement(By.xpath(Base.oR.getProperty("submit_btn"))).click();
}
@Then("the survey from should be successfully created")
public void the_survey_from_should_be_successfully_created() {
	wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("startAnalysis_btn"))));
	
    String expMsg = "";
    String actMsg = driver.findElement(By.xpath(Base.oR.getProperty("startAnalysis_btn"))).getText();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    softassert = new SoftAssert();
    softassert.assertEquals(expMsg, actMsg);
    softassert.assertAll();
    driver.findElement(By.xpath(Base.oR.getProperty("CreateAnotherSurvey"))).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    driver.findElement(By.xpath(Base.oR.getProperty("exit_btn"))).click();
    
}

@Given("that admin is signed in")
public void that_admin_is_signed_in() {
	driver.findElement(By.xpath(Base.oR.getProperty("email1_field"))).sendKeys("Dreadporticos@gmail.com");
	driver.findElement(By.xpath(Base.oR.getProperty("pasword_field"))).sendKeys("Password@12");
	driver.findElement(By.xpath(Base.oR.getProperty("signIn_button"))).click();
}

@And("select multiple job position")
public void select_multiple_job_position() {
	driver.findElement(By.xpath(Base.oR.getProperty("jobPosition_btn"))).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
}
@And("click the Add Job Position button")
public void click_the_add_job_position_button() {
	wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("addJobPosition_fld "))));
	driver.findElement(By.xpath(Base.oR.getProperty("addJobPosition_fld "))).click();
}
@And("select a job position")
public void select_a_job_position() {
	driver.findElement(By.xpath(Base.oR.getProperty("HR_tggl "))).click();
	WebElement devOption = driver.findElement(By.xpath(Base.oR.getProperty("dev_tggl ")));
	devOption.isDisplayed();
	devOption.click();
}
@And("Input title of survey in the survey field for job postion")
public void input_title_of_survey_in_the_survey_field_for_job_postion() {
	driver.findElement(By.xpath(Base.oR.getProperty("titleOfSurvery_fld"))).sendKeys("Survey Test1");
}
@And("Input age of data in the the age of data field for job position")
public void input_age_of_data_in_the_the_age_of_data_field_for_job_position() {
	driver.findElement(By.xpath(Base.oR.getProperty("ageOfData_fld"))).sendKeys("3");
}
@And("click on the country field for job position")
public void click_on_the_country_field_for_job_position() {
	WebElement country = driver.findElement(By.xpath(Base.oR.getProperty("country_fld")));
	sel = new Select(country);
	sel.selectByValue("1");
}
@And("select a country from the list of the menu for country for job position")
public void select_a_country_from_the_list_of_the_menu_for_country_for_job_position() {
	WebElement currency = driver.findElement(By.xpath(Base.oR.getProperty("curr_fld")));
	sel = new Select(currency);
	sel.selectByValue("1");
}
@And("click on the sponsor field for job position")
public void click_on_the_sponsor_field_for_job_position() {
	WebElement SurvSpons = driver.findElement(By.xpath(Base.oR.getProperty("surSpon_fld")));
	sel = new Select(SurvSpons);
	sel.selectByValue("1");
}
@And("select multiple sponsor for job position")
public void select_multiple_sponsor_for_job_position() {
	 System.out.println("Sponsor selected");
}
@And("select target from the industry dropdown for job position")
public void select_target_from_the_industry_dropdown_for_job_position() {
	WebElement tInd = driver.findElement(By.xpath(Base.oR.getProperty("targetIndustry_fld")));
	sel = new Select(tInd);
	sel.selectByValue("2");
}
@And("select multiple targets from the dropdown list for job position")
public void select_multiple_targets_from_the_dropdown_list_for_job_position() {
	  System.out.println("Multiple options selected");
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,500)");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
@And("click on the continue button to continue for job position")
public void click_on_the_continue_button_to_continue_for_job_position() {
	driver.findElement(By.xpath(Base.oR.getProperty("cont_btn"))).click();
}
@And("click the continue button after selecting a job position")
public void click_the_continue_button_after_selecting_a_job_position() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("super admin clicks on the survey button from the dashboard for job position")
public void super_admin_clicks_on_the_survey_button_from_the_dashboard_for_job_position() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("createSurveyDash"))));
	driver.findElement(By.xpath(Base.oR.getProperty("createSurveyDash"))).click();
	softassert = new SoftAssert();
	String expectedTxt = "Create a Survey";
	String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("createSurveyDash"))).getText();
	
	
	
	
//	String expectedAOD = "Age of Data";
//	String actualAOD = driver.findElement(By.xpath(Base.oR.getProperty("ageOfData_txt"))).getText();
//	
//	String expectTID = "Target Industry (s)";
//	String actualTID = driver.findElement(By.xpath(Base.oR.getProperty("tarInd_txt"))).getText();
//	System.out.println(driver.findElement(By.xpath(Base.oR.getProperty("createSurveyDash"))).getText());
//	
//	String expectedCtry = "Country";
//	String actualCtry = driver.findElement(By.xpath(Base.oR.getProperty("currency_txt"))).getText();
//	
//	String expCurr = "Currency";
//	String actCurr = driver.findElement(By.xpath(Base.oR.getProperty("currency_txt"))).getText();
//	
//	String expectedSurvSpon = "Survey Sponsor";
//	String actualSurvSpon = driver.findElement(By.xpath(Base.oR.getProperty("surSpon_txt"))).getText();
//	
//	softassert.assertEquals(actualSurvSpon, expectedSurvSpon);
	softassert.assertEquals(actualTxt, expectedTxt);
//	softassert.assertEquals(actualAOD, expectedAOD);
//	softassert.assertEquals(actualTID, expectTID);
//	softassert.assertEquals(actualCtry, expectedCtry);
//	softassert.assertEquals(actCurr, expCurr);
	softassert.assertAll();
	
}

@And("click on the edit survey details")
public void click_on_the_edit_survey_details() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    driver.findElement(By.xpath(Base.oR.getProperty("editSurvDet"))).click();
}
@And("edit title of survey")
public void edit_title_of_survey() {
	wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("titleOfSurvery_fld"))));
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.findElement(By.xpath(Base.oR.getProperty("titleOfSurvery_fld"))).sendKeys(Keys.CONTROL + "a");
	driver.findElement(By.xpath(Base.oR.getProperty("titleOfSurvery_fld"))).sendKeys(Keys.DELETE);
	driver.findElement(By.xpath(Base.oR.getProperty("titleOfSurvery_fld"))).sendKeys("TestSurvey10");
	driver.findElement(By.xpath(Base.oR.getProperty("cont_btn"))).click();
	driver.findElement(By.xpath(Base.oR.getProperty("exit_btn"))).click();
}

@And("click on the edit benchmark")
public void click_on_the_edit_benchmark() {
	driver.findElement(By.xpath(Base.oR.getProperty("editBenchLev"))).click();
	SoftAssert softassert = new SoftAssert();
	String actualTxt = "Change Benchmark Level";
	String expectedTxt = driver.findElement(By.xpath(Base.oR.getProperty("chge_ben_levl"))).getText();
	softassert.assertEquals(actualTxt, expectedTxt);
	softassert.assertAll();
}

@And("click on job family")
public void click_on_job_family() {
	driver.findElement(By.xpath(Base.oR.getProperty("jobFam_btn"))).click();
}
@And("select on Add Job Family")
public void select_on_add_job_family() {
	driver.findElement(By.xpath(Base.oR.getProperty("addJob_btn"))).click();
}
@And("select technicals and sports directors")
public void select_technicals_sports_directors() throws InterruptedException {
	driver.findElement(By.xpath(Base.oR.getProperty("tech_tggle"))).click();
	driver.findElement(By.xpath(Base.oR.getProperty("SprtDir_tggle"))).click();
	driver.findElement(By.xpath(Base.oR.getProperty("cCont_btn"))).click();
//	driver.wait(7000);
}
@And("click on the save and continue button")
public void click_on_the_save_and_continue_button() {
	driver.findElement(By.xpath(Base.oR.getProperty("cont2_btn"))).click();
//	driver.findElement(By.xpath(Base.oR.getProperty("saveCont_btn"))).click();
}

@And("click on edit benchmark levels")
public void click_on_edit_benchmark_levels() {
	driver.findElement(By.xpath(Base.oR.getProperty("editBenchLev"))).click();
}

@And("click on the edit options")
public void click_on_the_edit_options() {
	driver.findElement(By.xpath(Base.oR.getProperty("editOpt_btn"))).click();
}

@And("select a company")
public void select_a_company() {
	driver.findElement(By.xpath(Base.oR.getProperty("mmCompany_btn"))).click();
}

@And("click the submit button for completion")
public void click_the_submit_button_for_completion() {
	driver.findElement(By.xpath(Base.oR.getProperty("contn_btn"))).click();
}

@And("click the submit button in the preview page")
public void click_the_submit_button_in_the_preview_page() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath(Base.oR.getProperty("contnn_btn"))).click();
}

@When("super admin clicks on the survey module button")
public void super_admin_clicks_on_the_survey_module_button() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("survMod_btn"))));
	driver.findElement(By.xpath(Base.oR.getProperty("survMod_btn"))).click();
}
@Then("the following functionalities should display successfully")
public void the_following_functionalities_should_display_successfully() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("survSearch_field"))));
	driver.findElement(By.xpath(Base.oR.getProperty("survSearch_field"))).isDisplayed();
}

@Given("search for a survey by entering the survey name in the survey field")
public void search_for_a_survey_by_entering_the_survey_name_in_the_survey_field() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("getSurvName"))));
    String getSurveyName = driver.findElement(By.xpath(Base.oR.getProperty("getSurvName"))).getText();
    driver.findElement(By.xpath(Base.oR.getProperty("survSearch_field"))).sendKeys(getSurveyName);
}
@Then("the searched result should display successfully")
public void the_searched_result_should_display_successfully() {
	driver.findElement(By.xpath(Base.oR.getProperty("getSurvName"))).isDisplayed();
}


@Then("click the exit button")
public void click_the_exit_button() {
	 driver.findElement(By.xpath(Base.oR.getProperty("exit_btn"))).click();
}

@And("clicks on open on the searched survey")
public void clicks_on_open_on_the_searched_survey() {
	driver.findElement(By.xpath(Base.oR.getProperty("openSurvey"))).click();
}
@Then("the survey details should display successfully")
public void the_survey_details_should_display_successfully() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("survDetails_txt"))));
	String expectedTxt = "Survey Details";
	String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("survDetails_txt"))).getText();
    softassert = new SoftAssert();
    softassert.assertEquals(actualTxt, expectedTxt);
    softassert.assertAll();
    driver.findElement(By.xpath(Base.oR.getProperty("backBotton_btn"))).click();
}


}
