package RegistrationProcess;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import RegistrationBase.RegistrationPageVarsMethods;
import TestBase.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps extends TestBase {
	
		RegistrationPageVarsMethods registerMethods;
		
		public RegistrationSteps() {
			super();
		}

		//WebDriver driver;
		String fn = "Niya123";
		String ln = "Nila123"; 			
		String un = "Hibiscus" + new Random().nextInt(1000);
		String mail = "Daisy123@gmail.com";
		String pass1 = "testRun123";
		String pass2 = "testRun123";
		String successTitle = "Registration";
		String sucessContent = "Dear "+ fn +" " + ln + ","+ "\n\n" + "Your personal settings have been registered.";
		String finalSuccess = "The message has been sent to Nirmala1 abc1 (joy123)";
		String mailSuggestion = "Joy";
		String subjectLine = "This is a Test email";
		String mailContent = "Hello Ms,Joy" +"\n" + "This is for Testing" + "\n\n" + "From" + "\n" + "Nirmala";
		
		@Given("User navigated to signUp page from login page")
		public void user_navigated_to_sign_up_page_from_login_page() {
			initialization();
			registerMethods = new RegistrationPageVarsMethods();
		}

		@When("I click in SignUp link")
		public void i_click_in_sign_up_link() {
			registerMethods.clickOnSignUp();	
		}
		@When("I select the role Follow course")
		public void i_select_the_role_follow_course() {
			registerMethods.selectFollowCourse();

		}

		@When("I select the role Teach course")
		public void i_select_the_role_teach_course() {
			registerMethods.selectTeachCourse();
		}

		@When("Fill valid details")
		public void fill_valid_details() {
			registerMethods.fillRegistrationForm(fn, ln, mail, un, pass1, pass2);	
		}	
		

		@When("I fill some invalid Details {string},{string},{string},{string},{string},{string}")
		public void i_fill_some_invalid_details_as(String fne, String lne, String mal, String une, String pas1, String pas2) {
			registerMethods.fillRegistrationForm(fne, lne, mal, une, pas1, pas2);
		}

		@When("I click on register button")
		public void i_click_on_register_button() {
			registerMethods.clickOnRegisterBtn();
		}

		@Then("I should see Respective error message on the page")
		public void i_should_see_respective_error_message_on_the_page() {
			System.out.println("Registration failed because of the following reason : " + registerMethods.registerPgeWarnMessage());
		}

		@Then("I should see Registration successful")
		public void i_should_see_registration_successful() {
			registerMethods.validateSuccessMsg(successTitle, sucessContent);	
		}

		@When("I click on user image icon")
		public void i_click_on_user_image_icon() {
			registerMethods.clickOnUserIcon();
		}

		@Then("confirm registered email")
		public void confirm_registered_email() {
			junit.framework.Assert.assertEquals(mail, registerMethods.confirmUserMailId());
			System.out.println("Email Id matched as expected");
		}
		@When("I click on homepage")
		public void i_click_on_homepage() {
			registerMethods.clickOnHomePage();
		}
		
		@When("I click on compose")
		public void i_click_on_compose() {
			registerMethods.clickOnCompose();
		}
		
		@When("Type existing username and select a mail")
		public void type_existing_username_and_select_a_mail()  {
			registerMethods.sendToMailId(mailSuggestion);
		}
		
		@When("Type a mail subject")
		public void type_a_mail_subject() {
			registerMethods.sendSubjectLine(subjectLine);
		}
		
		@When("Type mail content")
		public void type_mail_content() {
			registerMethods.sendMailContent(mailContent);
		}
		@When("I click on send message")
		public void i_click_on_send_message() {
			registerMethods.clickOnsendMail();
		}
		@Then("Verify the message for successfully sending email")
		public void verify_the_message_for_successfully_sending_email() {
			String sentMail = registerMethods.validatesendMailConfirmation();
			junit.framework.Assert.assertEquals(finalSuccess, sentMail);
		}

		@Then("I close my browser")
		public void i_close_my_browser() {
			tearDown();
		}


}
