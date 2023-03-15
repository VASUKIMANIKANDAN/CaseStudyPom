package pageLoader;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Base.TestBase;


public class SelectItem extends TestBase{
	Alert alert;
	WebDriverWait wait;
	@FindBy(xpath="(//ul/li/a)[1]")
	public WebElement home;
	
	@FindBy(xpath="//div/a[@class='btn btn-success btn-lg']")
	public WebElement addtocartbtn; 
	public SelectItem() {
		PageFactory.initElements(driver, this);
	}
		
	public void select(String category,String product) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement cat = driver.findElement(By.partialLinkText(category));
		cat.click();
		WebElement prod =driver.findElement(By.partialLinkText(product));
		prod.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		addtocartbtn.click();		
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();
		home.click();
	}
}