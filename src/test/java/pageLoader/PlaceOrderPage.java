package pageLoader;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;


public class PlaceOrderPage extends TestBase{
	WebDriverWait wait;
	@FindBy(xpath="//button[text()='Place Order']")
	WebElement placeorder;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="card")
	WebElement card;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//button[text()='Purchase']")
	public WebElement purchase;
	
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	public WebElement message;
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void order() throws InterruptedException{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		placeorder.click();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		name.sendKeys(prop.getProperty("username"));
		country.sendKeys(prop.getProperty("country"));
		city.sendKeys(prop.getProperty("city"));
		card.sendKeys(prop.getProperty("credit"));
		month.sendKeys(prop.getProperty("month"));
		year.sendKeys(prop.getProperty("year"));
		wait.until(ExpectedConditions.elementToBeClickable(purchase));
		purchase.click();
		
	}
}