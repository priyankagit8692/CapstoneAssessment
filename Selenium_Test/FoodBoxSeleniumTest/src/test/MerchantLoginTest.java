package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MerchantLoginTest {

	 WebDriver driver ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MerchantLoginTest regTest = new MerchantLoginTest();
		regTest.setup();
		regTest.register();
		regTest.loginTest();
		regTest.alterMenu();
		regTest.addItems();
		regTest.search();
		regTest.sort();
		
	}
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\CapstoneProject\\Selenium_Test\\FoodBoxSeleniumTest\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		driver.get("http://localhost:4200/#/");
	}

	public void loginTest() {
		
		driver.manage().timeouts().implicitlyWait(35000,TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(35000,TimeUnit.MILLISECONDS);
		WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
		username.sendKeys("pkumawat091");
		
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(35000,TimeUnit.MILLISECONDS);
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
	    password.sendKeys("Pkpk@8692");
	    
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(.//*,'Login')]"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
	}
	
	public void register() {
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("pkumawat091");
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Pkpk@8692");
		WebElement firstname = driver.findElement(By.id("firstname"));
		firstname.sendKeys("Priyanka");
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		WebElement lastname = driver.findElement(By.id("lastname"));
		lastname.sendKeys("Kumawat");
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("priyankakumawat0086@gmail.com");
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("102 Pristine Society Pune");
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("9811111111");
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		Select account = new Select(driver.findElement(By.id("options")));
		account.selectByVisibleText("Merchant");
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		WebElement registerButton = driver.findElement(By.xpath("//button[contains(.//*,'Register')]"));
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		registerButton.click();
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
	}
	
	public void alterMenu() {
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		WebElement alterMenu = driver.findElement(By.xpath("//button[contains(.//*,'Alter Menu')]"));
		alterMenu.click();
	}
	
	public void addItems() {
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		js.executeScript("window.scrollBy(0,1000)");
		WebElement addItem = driver.findElement(By.xpath("//button[contains(.//*,'Add Item')]"));
		addItem.click();
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		
		WebElement id1 = driver.findElement(By.name("id"));
		id1.sendKeys("1");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement name1 = driver.findElement(By.name("name"));
		name1.sendKeys("Idli");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement price1 = driver.findElement(By.name("price"));
		price1.sendKeys("40");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);;
		WebElement quantity1 = driver.findElement(By.name("quantity"));
		quantity1.sendKeys("12");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement adItem = driver.findElement(By.xpath("//button[contains(.//*,'AddItem')]"));
		adItem.click();
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement menu = driver.findElement(By.xpath("//button[contains(.//*,'Menu')]"));
		menu.click();
		
		driver.manage().timeouts().implicitlyWait(7000,TimeUnit.MILLISECONDS);
		WebElement adItem1 = driver.findElement(By.xpath("//button[contains(.//*,'Add Item')]"));
		adItem1.click();
		WebElement username = driver.findElement(By.name("id"));
		username.sendKeys("2");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement password = driver.findElement(By.name("name"));
		password.sendKeys("Chai");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		WebElement firstname = driver.findElement(By.name("price"));
		firstname.sendKeys("10");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);;
		WebElement lastname = driver.findElement(By.name("quantity"));
		lastname.sendKeys("12");
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
		WebElement adItem2 = driver.findElement(By.xpath("//button[contains(.//*,'AddItem')]"));
		adItem2.click();
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(8000,TimeUnit.MILLISECONDS);
		WebElement menu1 = driver.findElement(By.xpath("//button[contains(.//*,'Menu')]"));
		menu1.click();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		
	}
	
	public void search()
	{
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
		WebElement name1 = driver.findElement(By.name("search"));
		name1.sendKeys("Idl");
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.MILLISECONDS);
		name1.clear();
		driver.navigate().refresh();
	}
	
	public void sort() {
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);
		Select account = new Select(driver.findElement(By.id("sort-by")));
		account.selectByVisibleText("Name");
		driver.manage().timeouts().implicitlyWait(80000,TimeUnit.MILLISECONDS);
		WebElement logout = driver.findElement(By.xpath("//button[contains(.//*,'Log Out')]"));
		logout.click();
		driver.manage().timeouts().implicitlyWait(80000,TimeUnit.MILLISECONDS);
		driver.close();
	}

}
