package testPackage;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import baseclassPackage.BaseclassOpencart;
import pagePackage.Checkout;
import pagePackage.Login;
import pagePackage.ProductToCart;
import pagePackage.SearchProduct;
import utilities.ExcelUtilities;

public class TestCart extends BaseclassOpencart {
	
	
	@Test
	public void testCartFunctionality() throws InterruptedException, IOException {
		Login login = new Login(driver);
		String xl = "D:\\Software_testing\\cartdetails.xlsx";
		String Sheet = "Sheet1";
		int rowCount = ExcelUtilities.getRowCount(xl, Sheet);
		for(int i = 1; i <= rowCount; i++) {
			login.signIn();
			String emailText = ExcelUtilities.getCellValue(xl, Sheet, i, 0);
            String passwordText = ExcelUtilities.getCellValue(xl, Sheet, i, 1);
            login.setCredentials(emailText, passwordText);
            login.loginClick();
            login.logout();
            //login.clearForm();
            
            //retrieve the details from the search product page
            SearchProduct searchProduct = new SearchProduct(driver);
            searchProduct.searchProduct("Desktops");
            searchProduct.select();
            searchProduct.check();
            searchProduct.searchClick();
            searchProduct.addCart();
            searchProduct.selectionsList();
            searchProduct.screenshot();
            
            // retrieve ProductToCart page
            ProductToCart product = new ProductToCart(driver);
            product.phonesMenuClick();
            product.addToCart();
            product.shoppingCartIconClick();
            product.tabletsShopping();
            product.camerasMenuClick();
            product.addProductSize(3);
             
            //retrieve methods for CheckoutPage
            Checkout checkout = new Checkout(driver);
            checkout.clickCheckoutMenu();
            checkout.clickCheckoutButton();
            checkout.clickItemsNumber();
   		}
        
    }

}
