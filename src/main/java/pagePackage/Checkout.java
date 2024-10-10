package pagePackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
	WebDriver driver;
	
	//locate the checkout menu
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[5]/a")
	WebElement checkoutMenu;
	
	//locate items number
	@FindBy(xpath = "//span[@id='cart-total']")
    WebElement itemsNumber;
	
	//locate the checkout button
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/a")
    WebElement checkoutButton;
	
	public Checkout(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//click on checkout menu
	public void clickCheckoutMenu() {
		checkoutMenu.click();
		System.out.println("The checkout menu has been clicked!");
		
	}
	
    //click the checkout button
	public void clickCheckoutButton() throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,550)", "");
        checkoutButton.click();
        Thread.sleep(2000);
        System.out.println("The checkout button has been clicked!");
        //Take screenshot of the checkout button
        File checkoutButtonScreenshot = checkoutButton.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(checkoutButtonScreenshot, new File("./Screenshot/checkoutButton.png"));
    }
	
	//click the item number
	public void clickItemsNumber() {
        itemsNumber.click();
    }

}
