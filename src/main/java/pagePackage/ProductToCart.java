package pagePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductToCart {

	WebDriver driver;
	//locate phones
		@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[6]/a")
		WebElement phones;
	
	//locate ad to cart buttons
		@FindBy(css = "button.add-to-cart") // Update with the actual selector
		private List<WebElement> addToCartButtons;
		
	//locate tablets
		@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[4]/a")
        WebElement tablets;
		
	//locate add to cart button for tablets
		@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")
        WebElement addToCartButtonTablet;
		
    //locate product cameras
		@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[7]/a")
        WebElement cameras;	
		
	//locate add to cart buttons for cameras
		@FindBy(css = ".product-layout")
	    List<WebElement> products;
	//locate add to cart buttons for cameras
		@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[1]/span")
        WebElement addToCart;
		
	//locate wishlist button
		@FindBy(xpath = "//*[@class = 'fa fa-heart']")
        WebElement wishlistButton;
		
	//locate the product size
	    @FindBy(id = "input-quantity")
	    WebElement size;
           		
	//locate shopping cart button
		@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[4]/a")
		WebElement shoppingCartButton;
		
    public ProductToCart(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);

    	}
    
//  method for waiting
    private void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    //method to click on phones menu
    public void phonesMenuClick() {
    	phones.click();
    }
    
    
    //methods to add all items to cart
    public void addToCart() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,450)", "");
	    
	       for (WebElement buttons : addToCartButtons) {
	            buttons.click();
           }
        System.out.println("Items added to cart successfully!");
        }
    
    
    //method to click on shopping cart button
    public void shoppingCartIconClick() {
    	shoppingCartButton.click();
        System.out.println("Shopping cart button clicked!");
    }
    //method to access shopping for tablets
    public void tabletsShopping() {
        tablets.click();
        System.out.println("Tablets menu clicked!");
        addToCartButtonTablet.click();
        System.out.println("Add to cart button for tablets clicked!");
        
    }
    
    //method to purchase camera
    public void camerasMenuClick() {
        cameras.click();
        System.out.println("Cameras menu clicked!");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        waitForElement(addToCart);
        addToCart.click();
        
    }
    
    //method to select a product size
    public void addProductSize(int qty) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        waitForElement(size);
        size.clear();
        size.sendKeys(String.valueOf(qty));
        Thread.sleep(2000);
        System.out.println("Product size inserted successfully!");
    }
         
        }
