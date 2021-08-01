package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {

	 WebDriver driver ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegisterTest regTest = new RegisterTest();
		regTest.setup();
		regTest.loginNegativeTest();
		//regTest.register();
	}
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\CapstoneProject\\Selenium_Test\\FoodBoxSeleniumTest\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
		driver.get("http://localhost:4200/#/");
	}
	
	public void loginNegativeTest() {
		WebElement loginLink = driver.findElement(By.linkText("Log In"));
		loginLink.click();
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("pkumawat");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Pkpk@8692");
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		WebElement loginButton = driver.findElement(By.linkText("Login"));
		loginButton.click();
		
		
		
	}
	
	public void register() {
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("pkumawat");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Pkpk@8692");
		WebElement firstname = driver.findElement(By.id("firstname"));
		firstname.sendKeys("Priyanka");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement lastname = driver.findElement(By.id("lastname"));
		lastname.sendKeys("Kumawat");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("priyankakumawat0086@gmail.com");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("9811111111");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		Select account = new Select(driver.findElement(By.id("options")));
		account.selectByVisibleText("Merchant");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement registerButton = driver.findElement(By.linkText("Register"));
		registerButton.click();
	}
	

}
