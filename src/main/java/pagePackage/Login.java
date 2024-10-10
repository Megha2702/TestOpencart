package pagePackage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;
	
	//locate my account
	//@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	@FindBy(xpath = "//span[contains(text(),'My Account')]")  
	WebElement myAccount;
	//locate sign in
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    WebElement signInButton;
			
	//locate login
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[1]")
	WebElement loginoption;
	//locate email
	@FindBy(id = "input-email")
    WebElement email;
	//locate password
	@FindBy(id = "input-password")
    WebElement password;
	
	//locate login button
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement loginButton;
	
	//locate logout button
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")
    WebElement logoutButton;
	
	//constructor
	public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	//  method for waiting
    private void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
	
	//method to signin the user
	public void signIn() {
		waitForElement(myAccount);
        myAccount.click();
        waitForElement(signInButton);
        signInButton.click();
    }
	
	//method to click login option
		public void login() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
		       js.executeScript("window.scrollBy(0,-450)", "");
		       if(loginoption.isDisplayed() && loginoption.isEnabled()) {
		    	   waitForElement(loginoption);
		            loginoption.click();
		       } else {
		    	   System.out.println("Login option is not visible or enabled");
		            throw new RuntimeException("Login option not available");
		       }
		}
		
		//method to set the values
		public void setCredentials(String emailText, String passwordText) throws InterruptedException {
			waitForElement(email);
	        email.clear();  // Ensure to clear old input
	        email.sendKeys(emailText);
            password.sendKeys(passwordText);
            
            waitForElement(password);
            password.clear();  // Ensure to clear old input
            password.sendKeys(passwordText);
		}
		
		    //method to enter email and password
		public void loginClick() {
			waitForElement(loginButton);
	        loginButton.click();
            System.out.println("The login button has been clicked");
        }
				
				
		//method to logout the user
		public void logout() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,250)", "");
            logoutButton.click();
            System.out.println("The logout button has been clicked");
        }

}
