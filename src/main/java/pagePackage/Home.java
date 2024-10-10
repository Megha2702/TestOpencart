package pagePackage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	WebDriver driver;
		
	//locate my account
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement myAccount;
	
	//locate registration
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement register;
	
	//locate firstname
	@FindBy(id = "input-firstname")
	WebElement firstName;
	
	//locate lastname
	@FindBy(id = "input-lastname")
    WebElement lastName;
	
	//locate email
	@FindBy(id = "input-email")
    WebElement email;
	
    //locate telephone
	@FindBy(id = "input-telephone")
    WebElement telephone;
	
	//locate password
	@FindBy(id = "input-password")
    WebElement password;
	
	//locate confirm password
	@FindBy(id = "input-confirm")
    WebElement confirmPassword;
	
	//locate newsletter checkbox
	@FindBy(name = "newsletter")
    WebElement newsletter;
	
	//locate agree checkbox
	@FindBy(name = "agree")
    WebElement agree;
	
	//locate continue button
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    WebElement continueButton;
	
		
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	//method to click on my account
	public void myAccountClick() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
		
	}
	//method to register
	public void registerClick() {
		register.click();
		
	}
	//method to fill in the registration form
	public void setValues(String fn, String ln, String emailId, String phone, String pwd, String confirmpwd) throws InterruptedException {
		Thread.sleep(2000);
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		email.sendKeys(emailId);
		telephone.sendKeys(String.valueOf(phone));
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmpwd);
			
	}
	//method to click button and radio buttons
	public void clickButton() throws InterruptedException {
		newsletter.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)", "");
		agree.click();
		Thread.sleep(4000);
        continueButton.click();
        System.out.println("Clicked");
    }
	
	//method to navigate back to registration form
	public void navigateBack() {
        driver.navigate().back();
    }
	
	
}
