package pagePackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProduct {
	WebDriver driver;
	
	//locate search bar for product search
	@FindBy(name = "search")
	WebElement searchBar;
	
    //locate search button
	@FindBy(xpath = "//*[@id=\"search\"]/span/button")
    WebElement searchButton;
	
	//locate dropdown for product
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/select")
	WebElement productDropdown;
	
    //locate checkbox for product
	@FindBy(name =  "description")
    WebElement productCheckbox;
	
	//locate search button for product
	@FindBy(id = "button-search")
    WebElement searchButtonProduct;
	
	//locate add button for product
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    WebElement addButton;
	
	//locate radio button
	@FindBy(xpath = "//div[@id='input-option218']//div[2]//label[1]")
    WebElement radioButton;
	
	//locate checkbox select for product
	@FindBy(xpath = "//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/label[1]/input[1]")
    WebElement checkboxSelect;
	
	//locate product color selection
	@FindBy(xpath = "//select[@id='input-option217']")
    WebElement productColor;
	
	//locate date selection
	@FindBy(xpath = "//*[@id=\"input-option219\"]")
    WebElement date;
	
	//time selection
	@FindBy(xpath = "//*[@id=\"input-option221\"]")
    WebElement time;
	
	//date and time location
	@FindBy(xpath = "//*[@id=\"input-option220\"]")
	WebElement dateAndTime;
	
	//locate addcart main button
	@FindBy(xpath = "//*[@id=\"button-cart\"]")
    WebElement addCartMainButton;
	
	
   public SearchProduct(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
   
   // method for waiting
   private void waitForElement(WebElement element) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
       wait.until(ExpectedConditions.visibilityOf(element));
   }
   
   //method to search for a product
   public void searchProduct(String product) {
       searchBar.sendKeys(product);
       searchButton.click();
   }
   
   //method to select 
   public void select() {
	   Select select = new Select(productDropdown);
	   select.selectByValue("20");
	   			   
   }
   
   //method to checkbox for product
   public void check() throws InterruptedException {
       
    productCheckbox.click();
    Thread.sleep(2000);
   }
   
   //method to click search button 
   public void searchClick() {
	   searchButtonProduct.click();
   }
   
   //method to click addcart button
   public void addCart() {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,650)", "");
       addButton.click();
   }
   
   //method to select radio button
   public void selectionsList() throws InterruptedException {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,650)", "");
	   waitForElement(radioButton);
       radioButton.click();
       JavascriptExecutor jss = (JavascriptExecutor) driver;
	   jss.executeScript("window.scrollBy(0,250)", "");
       checkboxSelect.click();
       JavascriptExecutor jsc = (JavascriptExecutor) driver;
	   jsc.executeScript("window.scrollBy(0,150)", "");
       Select selection = new Select(productColor);
       selection.selectByValue("3");
       JavascriptExecutor jscr = (JavascriptExecutor) driver;
	   jscr.executeScript("window.scrollBy(0,350)", "");
	   date.clear();
       date.sendKeys("2024-10-07");
       time.clear();
       time.sendKeys("08:45");
       JavascriptExecutor jsd = (JavascriptExecutor) driver;
       jsd.executeScript("window.scrollBy(0,250)", "");
       dateAndTime.clear();
       dateAndTime.sendKeys("2024-10-07 08:45");
       Thread.sleep(2000);
       waitForElement(addCartMainButton);
       addCartMainButton.click();
   }
   
   //method to take screenshot
   public void screenshot() throws IOException {
	   File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	   FileHandler.copy(src, new File("./Screenshot/screenshot.png"));
	   System.out.println("The screenshot has been saved");
	   
   }
   
   
    //method to get product name
}
