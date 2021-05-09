package RegistrationBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class RegistrationPageVarsMethods extends TestBase{	

	@FindBy(partialLinkText = "Sign")
	WebElement signUpLink;
	
	@FindBy(xpath = "//input[@class='register-profile']/following-sibling::p[contains(text(),'Follow')]")
	WebElement followOption;
	
	@FindBy(xpath = "//input[@class='register-profile']/following-sibling::p[contains(text(),'Teach')]")
	WebElement teachOption;
	
	@FindBy(name = "firstname")
	WebElement firstName;
	
	@FindBy(name = "lastname")
	WebElement lastName;
	
	@FindBy(name = "email")
	WebElement mailId;
	
	@FindBy(name = "username")
	WebElement userName;
	
	@FindBy(name = "pass1")
	WebElement passWord;
	
	@FindBy(name = "pass2")
	WebElement password2;
	
	@FindBy(id = "registration_submit")
	WebElement registerBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-warning']")
	WebElement registerPageMsg;
	
	@FindBy(className = "active")
	WebElement regiSuccMsgTtle;
	
	@FindBy(xpath = "//div[@class='row']/div/p[1]")
	WebElement regiSuccMsgFul;
	
	@FindBy(className = "dropdown-toggle")
	WebElement userIcon;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu']/li/div/p")
	WebElement userMailId;
	
	@FindBy(className = "homepage")
	WebElement homePageMenu;
	
	@FindBy(linkText = "Compose")
	WebElement composeOption;
	
	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement sendToMailBox;	
	
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement mailIdSuggestions;
	
	@FindBy(id = "compose_message_title")
	WebElement subjectBox;
		
	@FindBy(xpath = "//div[@id='cke_1_contents']/iframe[@title='Rich Text Editor, content']")
	WebElement iframe;
	
	@FindBy(xpath = "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	WebElement messageBox;
	
	@FindBy(id = "compose_message_compose")
	WebElement sendBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement sendMailConfirmation;

	
	public RegistrationPageVarsMethods() {
		PageFactory.initElements(driver, this);	
	}
	
	public void clickOnSignUp() {
		signUpLink.click();
	}
	
	public void selectFollowCourse() {
		followOption.click();
	}
	
	public void selectTeachCourse() {
		teachOption.click();
	}
	
	public void fillRegistrationForm(String fn, String ln, String mail, String un, String pass1, String pass2) {
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		mailId.sendKeys(mail);
		userName.sendKeys(un);
		passWord.sendKeys(pass1);
		password2.sendKeys(pass2);
	}	
	
	public void clickOnRegisterBtn() {
		registerBtn.click();
	}
	
	public String registerPgeWarnMessage() {
		String warningMessage = registerPageMsg.getText();
		return warningMessage;
	}
	
	public String[] registerPgeSuccMessage() {
		String msgTitle = regiSuccMsgTtle.getText();
		String msgFul = regiSuccMsgFul.getText();
		String[] successMsg = new String[2];
		successMsg[0] = msgTitle;
		successMsg[1] = msgFul;
		return successMsg;	
	}
	
	public void validateSuccessMsg(String actualTitle, String ActualMsg) {	
		junit.framework.Assert.assertEquals(actualTitle, registerPgeSuccMessage()[0]);
		junit.framework.Assert.assertEquals(ActualMsg, registerPgeSuccMessage()[1]);
	}	
	
	public void clickOnUserIcon() {
		userIcon.click();
	}
	
	public String confirmUserMailId() {
		String usermail = userMailId.getText();
		return usermail;
	}
	
	public void clickOnHomePage() {
		homePageMenu.click();
	}
	
	public void clickOnCompose() {
		composeOption.click();
	}
	
	public void sendToMailId(String mailId) {
		sendToMailBox.click();
		sendToMailBox.sendKeys(mailId);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(mailIdSuggestions));
		Actions act = new Actions(driver);
		act.moveToElement(mailIdSuggestions).build().perform();
		act.click().build().perform();
		act.sendKeys(Keys.TAB).perform();	
	}

	public void sendSubjectLine(String subjectLine) {
		//subjectBox.click();
		subjectBox.sendKeys(subjectLine);
	}
	
	public void sendMailContent(String mailContent) {
		driver.switchTo().frame(iframe);
		messageBox.click();
		messageBox.sendKeys(mailContent);
		driver.switchTo().defaultContent();
	}
	
	public void clickOnsendMail() {
		sendBtn.click();
	}
	
	public String validatesendMailConfirmation() {
		String mailSent = sendMailConfirmation.getText();
		return mailSent;
	}
}

