package baseclassPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseclassOpencart {
	public static WebDriver driver;
	String url ="https://awesomeqa.com/ui/";
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
}
