package abstracta.examen.selenium.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	private WebDriver driver;
	
	public Base(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriver chromeDriver()
	{
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement(By locator)
	{
		return driver.findElement(locator);
		
	}
	
	public List<WebElement> findElements(By locator)
	{
		return driver.findElements(locator);
		
	}
	
	public String getText(WebElement element)
	{
		return element.getText();
	}
	
	public String getText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public void setText(String text, By locator)
	{
		driver.findElement(locator).sendKeys(text);
	}
	
	public void click(By locator) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(locator).click();
	}
	
	public void scrollEndPage(By locator) throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", driver.findElement(locator));
	}
	
	public Boolean isDisplayed(By locator)
	{
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit(String url)
	{
		driver.get(url);
	}
}
