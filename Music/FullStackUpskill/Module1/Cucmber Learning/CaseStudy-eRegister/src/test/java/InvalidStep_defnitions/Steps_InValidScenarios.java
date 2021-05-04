package InvalidStep_defnitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps_InValidScenarios {
	WebDriver driver;
	String warningMessage;
	@Given("User navigated to signUp page from login page")
	public void user_navigated_to_sign_up_page_from_login_page() {
		System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
		//this is to open the new instance of browser
		driver = new ChromeDriver();
		//This is basically to opent the application
		driver.get("http://elearningm1.upskills.in/");
		//if i want to maximize the screen
		driver.manage().window().maximize();
		//if i want to wait for sometime
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	 
	}

	@When("I click in SignUp link")
	public void i_click_in_sign_up_link() {
		driver.findElement(By.partialLinkText("Sign")).click();		  
	}

	@When("I select the role Follow course")
	public void i_select_the_role_follow_course() {
		driver.findElement(By.xpath("//input[@class='register-profile']/following-sibling::p[contains(text(),'Follow')]")).click();
	}

	@When("I select the role Teach course")
	public void i_select_the_role_teach_course() {
		driver.findElement(By.xpath("//input[@class='register-profile']/following-sibling::p[contains(text(),'Teach')]")).click();
	}


	@When("I enter firstname as {string}")
	public void i_enter_firstname_as(String string) {
		driver.findElement(By.name("firstname")).sendKeys(string);
	}

	@When("I enter lastname as {string}")
	public void i_enter_lastname_as(String string) {
		driver.findElement(By.name("lastname")).sendKeys(string);
	}

	@When("I enter email as {string}")
	public void i_enter_email_as(String string) {
		driver.findElement(By.name("email")).sendKeys(string);
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String string) {
		driver.findElement(By.name("username")).sendKeys(string);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String string) {
		driver.findElement(By.name("pass1")).sendKeys(string);
	}
	@When("I confirm password as {string}")
	public void i_confirm_password_as(String string) {
		driver.findElement(By.name("pass2")).sendKeys(string);
	}
	@When("I click on register button")
	public String i_click_on_register_button() {
		driver.findElement(By.id("registration_submit")).click();
		warningMessage = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();
		return warningMessage;
	}

	@Then("I should see Respective error message on the page")
	public void i_should_see_respective_error_message_on_the_page() {
		System.out.println("Registration failed because of the following reason : " + warningMessage);
	}

	@Then("I close my browser")
	public void i_close_my_browser() {
		driver.close();
	}



}