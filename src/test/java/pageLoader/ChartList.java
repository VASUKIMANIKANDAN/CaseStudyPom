package pageLoader;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class ChartList extends TestBase{
	public String pval_del;
	public int del_cart_size;
	WebDriverWait wait;
	@FindBy(xpath="(//td/a)[2]")
	WebElement deletebtn;
	
	public ChartList() {
		PageFactory.initElements(driver, this);
	}

	public void delete() {
		deletebtn.click();
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		pval_del = driver.findElement(By.id("totalp")).getText();
		del_cart_size = driver.findElements(By.xpath("//tbody//td[2]")).size();
	}
	
}
