package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementValidation {
	public static WebDriver driver = Base.getDriver();
	SoftAssert softassert;
	WebDriverWait wait;
	Select sel;
	
	@And("super admin clicks on the manage user button")
	public void super_admin_clicks_on_the_manage_user_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("manageUserMod"))));
		driver.findElement(By.xpath(Base.oR.getProperty("manageUserMod"))).click();
	}
	@Then("the manage user page should display succesfully")
	public void the_manage_user_page_should_display_succesfully() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("userTab_btn"))));
	    softassert = new SoftAssert();
	    String expectedUserTab = "Users";
	    String actualUserTab = driver.findElement(By.xpath(Base.oR.getProperty("userTab_btn"))).getText();
	    System.out.println(actualUserTab);
	    softassert.assertEquals(actualUserTab, expectedUserTab);
	    
	    String expectedRoleTab = "Roles";
	    String actualRoleTab = driver.findElement(By.xpath(Base.oR.getProperty("roleTab_btn"))).getText();
	    System.out.println(actualRoleTab);
	    softassert.assertEquals(actualRoleTab, expectedRoleTab);
	    
	    String expectedFilterTab = "Filter";
	    String actualFilterTab = driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).getText();
	    System.out.println(actualFilterTab);
	    softassert.assertEquals(actualFilterTab, expectedFilterTab);
	    softassert.assertAll();
	}
	
	@When("clicks on the user tab")
	public void clicks_on_the_user_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("userTab_btn"))));
	    driver.findElement(By.xpath(Base.oR.getProperty("userTab_btn"))).click();
	}
	@Then("the user tab page should open successful")
	public void the_user_tab_page_should_open_successful() {
	    softassert = new SoftAssert();
	    String expectedTxt= "";
	    String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("searchUser_fld"))).getText();
	    softassert.assertEquals(actualTxt, expectedTxt);
	    String expfilterTxt = "Filter";
	    String actFilterTxt = driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).getText();
	    softassert.assertEquals(actFilterTxt, expfilterTxt);
	    
	    String expNewUserBtnTxt = "New User";
	    String actNewUserBtnTxt = driver.findElement(By.xpath(Base.oR.getProperty("newUserbtn"))).getText();
	    softassert.assertEquals(actNewUserBtnTxt, expNewUserBtnTxt);
	    
	    
	    softassert.assertAll();
	}
	
	@And("enter user name in the search field")
	public void enter_user_name_in_the_search_field() {
		try {
			Thread.sleep(Duration.ofSeconds(2));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath(Base.oR.getProperty("searchUser_fld"))).sendKeys("Cole");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}
	@Then("the search result should be successful")
	public void the_search_result_should_be_successful() {
		softassert = new SoftAssert();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("getUserName"))));
		String expectedTxt = "Palmer";
		String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("getUserName"))).getText();
		softassert.assertEquals(actualTxt, expectedTxt);
		softassert.assertAll();
	}
	
	@And("clicks on the New User button")
	public void clicks_on_the_new_user_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("newUserbtn"))).click();
	}
	@Then("a new user form in the form of prompt should display")
	public void a_new_user_form_in_the_form_of_prompt_should_display() {
		driver.findElement(By.xpath(Base.oR.getProperty("firstName_txt"))).isDisplayed();
		driver.findElement(By.xpath(Base.oR.getProperty("lastName_txt"))).isDisplayed();
		driver.findElement(By.xpath(Base.oR.getProperty("emaiAddy_txt"))).isDisplayed();
		driver.findElement(By.xpath(Base.oR.getProperty("userRole_txt"))).isDisplayed();
		driver.findElement(By.xpath(Base.oR.getProperty("cancelForm_btn"))).isDisplayed();
	}
	@And("clicks on the cancel button from the prompt")
	public void click_on_the_cancel_button_from_the_prompt() {
		driver.findElement(By.xpath(Base.oR.getProperty("cancelForm_btn"))).click();
	}
	
	@Then("enters first name in the first name field")
	public void enters_first_name_in_the_first_name_field() {
		driver.findElement(By.xpath(Base.oR.getProperty("fName_fld"))).sendKeys("NewUser");
	}
	@Then("enters last name in the last name field")
	public void enters_last_name_in_the_last_name_field() {
		driver.findElement(By.xpath(Base.oR.getProperty("lName_fld"))).sendKeys("Test");
	}
	@Then("enters email in the email address field")
	public void enters_email_in_the_email_address_field() {
		driver.findElement(By.xpath(Base.oR.getProperty("email_fld"))).sendKeys("NewUserTest09@gmail.com");
	}
	@Then("select a role for the new user")
	public void select_a_role_for_the_new_user() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("UserRole_fld"))));
		WebElement userRole = driver.findElement(By.xpath(Base.oR.getProperty("UserRole_fld")));
	    sel = new Select(userRole);
	    sel.selectByValue("54");
	}
	@Then("clicks on the Add user button")
	public void clicks_on_the_add_user_button() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath(Base.oR.getProperty("addUser_btn"))).click();
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Base.oR.getProperty("addUser_btn"))));
	}
	@Then("a new user should be successfully created")
	public void a_new_user_should_be_successfully_created() {
		softassert = new SoftAssert();
		String expfilterTxt = "Filter";
		String actFilterTxt = driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).getText();
		softassert.assertEquals(actFilterTxt, expfilterTxt);
		softassert.assertAll();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
	}
	
	@And("clicks the filter button")
	public void clicks_the_filter_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).click();
	}
	@Then("the status filter option should display")
	public void the_status_filter_option_should_display() {
		driver.findElement(By.xpath(Base.oR.getProperty("status_fld"))).isDisplayed();
	}
	@And("selects the deactivate option")
	public void selects_the_deactivate_option() {
		WebElement status = driver.findElement(By.xpath(Base.oR.getProperty("status_fld")));
		sel = new Select(status);
		sel.selectByVisibleText("Deactivated");
	}
	@Then("list of deactivated users should display successfully")
	public void list_of_deactivated_users_should_display_successfully() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("val_deactivate"))));
		softassert = new SoftAssert();
	    String expectedTxt = "DEACTIVATED";
	    String actTxt = driver.findElement(By.xpath(Base.oR.getProperty("val_deactivate"))).getText();
	    softassert.assertEquals(actTxt, expectedTxt);
	    softassert.assertAll();
	    
	}
	
	@And("selects the activate option")
	public void selects_the_activate_option() {
		WebElement status = driver.findElement(By.xpath(Base.oR.getProperty("status_fld")));
		sel = new Select(status);
		sel.selectByVisibleText("Activated");
	}
	@Then("list of activated users should display successfully")
	public void list_of_activated_users_should_display_successfully() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("val_activated"))));
		softassert = new SoftAssert();
	    String expectedTxt = "ACTIVATED";
	    String actTxt = driver.findElement(By.xpath(Base.oR.getProperty("val_activated"))).getText();
	    softassert.assertEquals(actTxt, expectedTxt);
	    softassert.assertAll();
	}
	
	
	@And("selects the all option")
	public void selects_the_all_option() {
		WebElement status = driver.findElement(By.xpath(Base.oR.getProperty("status_fld")));
		sel = new Select(status);
		sel.selectByVisibleText("All");
	}
	
	@Then("list of all users should display successfully")
	public void list_of_all_users_should_display_successfully() {
		softassert = new SoftAssert();
	    String expectedTxt = "ACTIVATED";
	    String actTxt = driver.findElement(By.xpath(Base.oR.getProperty("val_activated"))).getText();
	    softassert.assertEquals(actTxt, expectedTxt);
	    
	    String expectedDeactivated = "DEACTIVATED";
	    String actDeactivated = driver.findElement(By.xpath(Base.oR.getProperty("val_deactivate"))).getText();
	    softassert.assertEquals(actDeactivated, expectedDeactivated);
	    softassert.assertAll();
	}
	
	@Then("clicks the close filter button and it should be successful")
	public void clicks_the_close_filter_button_and_it_should_be_successful() {
		driver.findElement(By.xpath(Base.oR.getProperty("closeFilter_btn"))).click();
	}
	
	@And("clicks the elipses button of the user to modify")
	public void clicks_the_elipses_button_of_the_user_to_modify() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(3));
	    driver.findElement(By.xpath(Base.oR.getProperty("elipses_btn"))).click();
	}
	@And("clicks on the Change Role button")
	public void clicks_on_the_change_role_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("changeRole_btn"))).click();
	}
	@And("modify the user role from the user role field")
	public void modify_the_user_role_from_the_user_role_field() {
		
	   WebElement userRoleFld = driver.findElement(By.xpath(Base.oR.getProperty("userRole_fld")));
	   sel = new Select(userRoleFld);
	   sel.selectByVisibleText("NewRoleTest6");
	}
	@Then("click the update role button")
	public void click_the_update_role_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("updateRole_btn"))).click();
	}
	
	
	@And("the role should be successfully updated")
	public void the_role_should_be_successfully_updated() {
		  softassert = new SoftAssert();
		    String expectedTxt= "";
		    String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("searchUser_fld"))).getText();
		    softassert.assertEquals(actualTxt, expectedTxt);
		    String expfilterTxt = "Filter";
		    String actFilterTxt = driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).getText();
		    softassert.assertEquals(actFilterTxt, expfilterTxt);
		    
		    String expNewUserBtnTxt = "New User";
		    String actNewUserBtnTxt = driver.findElement(By.xpath(Base.oR.getProperty("newUserbtn"))).getText();
		    softassert.assertEquals(actNewUserBtnTxt, expNewUserBtnTxt);
		    softassert.assertAll();
	}
	
	@And("re-enter user name in the search field")
	public void re_enter_user_name_in_the_search_field() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(3));
		driver.findElement(By.xpath(Base.oR.getProperty("searchUser2_fld"))).sendKeys("Cole");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	@And("modify the user role back to it previous role")
	public void modify_the_user_role_back_to_it_previous_role() {
		 WebElement userRoleFld = driver.findElement(By.xpath(Base.oR.getProperty("userRole_fld")));
		   sel = new Select(userRoleFld);
		   sel.selectByVisibleText("Super Admin");
	}
	
	@And("clicks on the View Details button")
	public void clicks_on_the_view_details_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("viewDetail_btn"))).click();
	}
	@Then("the user details should display successfully")
	public void the_user_details_should_display_successfully() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("getUserName_txt"))));
	    softassert = new SoftAssert();
	    String expectedName = "Palmer";
	    String actualName = driver.findElement(By.xpath(Base.oR.getProperty("getUserName_txt"))).getText();
	    softassert.assertEquals(actualName, expectedName);
	    driver.findElement(By.xpath(Base.oR.getProperty("acctStatus_txt"))).isDisplayed();
	    driver.findElement(By.xpath(Base.oR.getProperty("getRole_txt"))).isDisplayed();
	    softassert.assertAll();
	    
	}
	
	
	@And("click the deactivate button")
	public void click_the_deactivate_button() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(2));
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("deaactive_btn"))));
		driver.findElement(By.xpath(Base.oR.getProperty("deaactive_btn"))).click();
	}
	@Then("the account should be deactivated successfully")
	public void the_account_should_be_deactivated_successfully() {
		softassert = new SoftAssert();
	    String expectedTxt= "";
	    String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("searchUser_fld"))).getText();
	    softassert.assertEquals(actualTxt, expectedTxt);
	    String expfilterTxt = "Filter";
	    String actFilterTxt = driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).getText();
	    softassert.assertEquals(actFilterTxt, expfilterTxt);
	    
	    String expNewUserBtnTxt = "New User";
	    String actNewUserBtnTxt = driver.findElement(By.xpath(Base.oR.getProperty("newUserbtn"))).getText();
	    softassert.assertEquals(actNewUserBtnTxt, expNewUserBtnTxt);
	    softassert.assertAll();
	}
	@And("click the reactivate button")
	public void click_the_reactivate_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("reactivate_btn"))).click();
	}
	@Then("the account should be activated sucessfully")
	public void the_account_should_be_activated_sucessfully() {
		softassert = new SoftAssert();
	    String expectedTxt= "";
	    String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("searchUser_fld"))).getText();
	    softassert.assertEquals(actualTxt, expectedTxt);
	    String expfilterTxt = "Filter";
	    String actFilterTxt = driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).getText();
	    softassert.assertEquals(actFilterTxt, expfilterTxt);
	    
	    String expNewUserBtnTxt = "New User";
	    String actNewUserBtnTxt = driver.findElement(By.xpath(Base.oR.getProperty("newUserbtn"))).getText();
	    softassert.assertEquals(actNewUserBtnTxt, expNewUserBtnTxt);
	    softassert.assertAll();
	}
	
	@Then("click the deactivate button in the prompt")
	public void click_the_deactivate_button_in_the_prompt() {
		driver.findElement(By.xpath(Base.oR.getProperty("deactivate2_btn"))).click();
	}
	@Then("click the activate button in the prompt")
	public void click_the_activate_button_in_the_prompt() {
		driver.findElement(By.xpath(Base.oR.getProperty("activate_btn"))).click();
	}
	
	@And("click the cancel button")
	public void click_the_cancel_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("cancelActDeact_btn"))).click();
	}
	@Then("the cancel button should be successful")
	public void the_cancel_button_should_be_successful() {
		softassert = new SoftAssert();
	    String expectedTxt= "";
	    String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("searchUser_fld"))).getText();
	    softassert.assertEquals(actualTxt, expectedTxt);
	    String expfilterTxt = "Filter";
	    String actFilterTxt = driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).getText();
	    softassert.assertEquals(actFilterTxt, expfilterTxt);
	    
	    String expNewUserBtnTxt = "New User";
	    String actNewUserBtnTxt = driver.findElement(By.xpath(Base.oR.getProperty("newUserbtn"))).getText();
	    softassert.assertEquals(actNewUserBtnTxt, expNewUserBtnTxt);
	    softassert.assertAll();
	}
	
	@And("enter the user name on the search field")
	public void enter_the_user_name_on_the_search_field() {
		try {
			Thread.sleep(Duration.ofSeconds(2));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath(Base.oR.getProperty("searchUser_fld"))).sendKeys("NewUser");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	}
	@And("clicks the remove this user button")
	public void clicks_the_remove_this_user_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("removeUser_btn"))).click();
	}
	@And("clicks on the delete button")
	public void clicks_on_the_delete_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("deleteUser_btn"))).click();
	}
	@Then("the user should be removed successfully")
	public void the_user_should_be_removed_successfully() {
		softassert = new SoftAssert();
	    String expectedTxt= "";
	    String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("searchUser_fld"))).getText();
	    softassert.assertEquals(actualTxt, expectedTxt);
	    String expfilterTxt = "Filter";
	    String actFilterTxt = driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).getText();
	    softassert.assertEquals(actFilterTxt, expfilterTxt);
	    
	    String expNewUserBtnTxt = "New User";
	    String actNewUserBtnTxt = driver.findElement(By.xpath(Base.oR.getProperty("newUserbtn"))).getText();
	    softassert.assertEquals(actNewUserBtnTxt, expNewUserBtnTxt);
	    softassert.assertAll();
	}
	
	@And("clicks on the role tab")
	public void clicks_on_the_role_tab() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("roleTab_btn"))));
		driver.findElement(By.xpath(Base.oR.getProperty("roleTab_btn"))).click();
	}
	@Then("the role tab should display successfully")
	public void the_role_tab_should_display_successfully() {
		driver.findElement(By.xpath(Base.oR.getProperty("bulkAction_btn"))).isDisplayed();
		driver.findElement(By.xpath(Base.oR.getProperty("addRole_btn"))).isDisplayed();
		driver.findElement(By.xpath(Base.oR.getProperty("roleSearch_fld"))).isDisplayed();
	}
	
	@And("enter the role name to search with in the role field")
	public void enter_the_role_name_to_search_with_in_the_role_field() {
		driver.findElement(By.xpath(Base.oR.getProperty("roleSearch_fld"))).sendKeys("SUPER ADMIN");
	}
	@Then("the role with the role name search with should display successfully")
	public void the_role_with_the_role_name_search_with_should_display_successfully() {
		driver.findElement(By.xpath(Base.oR.getProperty("val_sysAdmin_txt"))).isDisplayed();
	}
	
	@And("clicks on the add role button")
	public void clicks_on_the_add_role_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("addRole_btn"))).click();
	}
	@Then("clicks on the cancel button")
	public void clicks_on_the_cancel_button() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Base.oR.getProperty("roleCancel_btn"))));
		driver.findElement(By.xpath(Base.oR.getProperty("roleCancel_btn"))).click();
	}
	@And("the role cancelation should be successful")
	public void the_role_cancelation_should_be_successful() {
		driver.findElement(By.xpath(Base.oR.getProperty("roleTab_btn"))).click();
		driver.findElement(By.xpath(Base.oR.getProperty("bulkAction_btn"))).isDisplayed();
		driver.findElement(By.xpath(Base.oR.getProperty("addRole_btn"))).isDisplayed();
		driver.findElement(By.xpath(Base.oR.getProperty("roleSearch_fld"))).isDisplayed();
	}
	
	
	@And("enter new role name")
	public void enter_new_role_name() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Base.oR.getProperty("addRole_btn"))));
		driver.findElement(By.xpath(Base.oR.getProperty("createNewRole_fld"))).sendKeys("NewRoleTest6");
	}
	@And("selects  can edit checkbox  as User Management")
	public void selects_can_edit_checkbox_as_user_management() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Base.oR.getProperty("addRole_btn"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("userMgmt_btn"))));
		driver.findElement(By.xpath(Base.oR.getProperty("userMgmt_btn"))).click();
		driver.findElement(By.xpath(Base.oR.getProperty("canEdit_tggle"))).click();
	}
	@And("selects the  Head Of Department dropdown")
	public void selects_the_head_of_department_dropdown() {
		driver.findElement(By.xpath(Base.oR.getProperty("HOD_btn"))).click();
	}
	@And("select  Head Of Department as super admin optional")
	public void select_head_of_department_as_super_admin_optional() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Base.oR.getProperty("superAdmin_btn"))));
		driver.findElement(By.xpath(Base.oR.getProperty("superAdmin_btn"))).click();
	}
	@And("clicks on the Save button to add new role")
	public void clicks_on_the_save_button_to_add_new_role() {
		driver.findElement(By.xpath(Base.oR.getProperty("roleSave_btn"))).click();
	}
	@Then("the new role should be successfully created")
	public void the_new_role_should_be_successfully_created() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Base.oR.getProperty("roleSave_btn"))));
		softassert = new SoftAssert();
	    String expectedTxt= "";
	    String actualTxt = driver.findElement(By.xpath(Base.oR.getProperty("searchUser_fld"))).getText();
	    softassert.assertEquals(actualTxt, expectedTxt);
	    String expfilterTxt = "Filter";
	    String actFilterTxt = driver.findElement(By.xpath(Base.oR.getProperty("filter_btn"))).getText();
	    softassert.assertEquals(actFilterTxt, expfilterTxt);
	    
	    String expNewUserBtnTxt = "New User";
	    String actNewUserBtnTxt = driver.findElement(By.xpath(Base.oR.getProperty("newUserbtn"))).getText();
	    softassert.assertEquals(actNewUserBtnTxt, expNewUserBtnTxt);
	    softassert.assertAll();
	}
	
	@And("enter role name to search for in the search field")
	public void enter_role_name_to_search_for_in_the_search_field() {
		driver.findElement(By.xpath(Base.oR.getProperty("roleSearch_fld"))).sendKeys("NewRoleTest4");
	}
	@Then("the role name searched for should display successfully")
	public void the_role_name_searched_for_should_display_successfully() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Base.oR.getProperty("roleElipseOption_btn"))));
		driver.findElement(By.xpath(Base.oR.getProperty("roleElipseOption_btn"))).isDisplayed();
	}
	@And("click the elipse button to display the options")
	public void click_the_elipse_button_to_display_the_options() {
		driver.findElement(By.xpath(Base.oR.getProperty("roleElipseOption_btn"))).click();
	}
	@And("click on the remove role button")
	public void click_on_the_remove_role_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("removeRole_btn"))).click();
	}
	@And("click the delete role button")
	public void click_the_delete_role_button() {
		driver.findElement(By.xpath(Base.oR.getProperty("deleteRole_btn"))).click();
	}
	@Then("role should be deleted successfully")
	public void role_should_be_deleted_successfully() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(2));
		driver.findElement(By.xpath(Base.oR.getProperty("roleTab_btn"))).click();
	}




}
