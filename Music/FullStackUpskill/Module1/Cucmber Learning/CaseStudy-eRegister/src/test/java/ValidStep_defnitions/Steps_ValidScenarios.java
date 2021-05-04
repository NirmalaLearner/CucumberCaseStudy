package ValidStep_defnitions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps_ValidScenarios {
	WebDriver driver;
	String fn = "Niya123";
	String ln = "Nila123"; 			
	String un = "Hibiscus" + new Random().nextInt(1000);

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


	@When("I select the role Tech course")
	public void i_select_the_role_tech_course() {
		driver.findElement(By.xpath("//input[@class='register-profile']/following-sibling::p[contains(text(),'Teach')]")).click();

	}

	@When("Fill valid details")
	public void fill_valid_details() {
		driver.findElement(By.name("firstname")).sendKeys(fn);
		driver.findElement(By.name("lastname")).sendKeys(ln);
		driver.findElement(By.name("email")).sendKeys("Nirmalabcy@gmail.com");
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("pass1")).sendKeys("test456");
		driver.findElement(By.name("pass2")).sendKeys("test456");
		driver.findElement(By.id("registration_submit")).click();	
	}


	@Then("I should see Registration successful")
	public void i_should_see_registration_successful() {
		String regMsgTtle = driver.findElement(By.className("active")).getText();
		junit.framework.Assert.assertEquals("Registration", regMsgTtle);
		String successMsgWithUserName = driver.findElement(By.xpath("//div[@class='row']/div/p[1]")).getText();
		junit.framework.Assert.assertEquals("Dear "+fn+" "+ln+"," +"\n" +"\n" +"Your personal settings have been registered.", successMsgWithUserName);		
	}


	@Then("I close my browser")
	public void i_close_my_browser() {
		driver.close();
	}
}
