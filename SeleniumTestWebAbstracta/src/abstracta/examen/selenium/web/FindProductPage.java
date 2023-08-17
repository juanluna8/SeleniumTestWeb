package abstracta.examen.selenium.web;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindProductPage extends Base {

	//locators
	By insertProductLocator = By.id("cb1-edit"); 
	By findProductLocator = By.className("nav-icon-search");
	
	By listProductLocator = By.cssSelector("li.ui-search-layout__item");
	By titleProductLocator = By.cssSelector("h2.ui-search-item__title");
	By priceProductLocator = By.cssSelector("span.andes-money-amount__fraction");
	By linkProductLocator = By.tagName("a");
	By pageNumberLocator = By.cssSelector("span.andes-pagination__link");
	
	By btnNextPageLocator = By.cssSelector("li[class='andes-pagination__button andes-pagination__button--next shops__pagination-button']");
	By btnBackPageLocator = By.cssSelector("li[class='andes-pagination__button andes-pagination__button--back shops__pagination-button']");
	
	//list of products
	List<WebElement> products;
	
	public FindProductPage(WebDriver driver) {
		super(driver);
	}

	public void findProduct(String product) throws InterruptedException
	{
		if(isDisplayed(insertProductLocator))
		{
			setText(product, insertProductLocator);
			
			click(findProductLocator);
		}else
		{
			System.out.println("Not correct page");
		}
	}
	
	public void listProducts()
	{
		products = findElements(listProductLocator);
	}
	
	
	
	public void goNextProductPage() throws InterruptedException
	{

		
		switch (findElement(pageNumberLocator).getText()) { 
	    case "1":
			System.out.println("page 1");
	    	scrollEndPage(btnNextPageLocator);
	    	click(btnNextPageLocator);
	     break;
	    case "2":
	    	System.out.println("page 2");
	    	scrollEndPage(btnNextPageLocator);
	    	click(btnNextPageLocator);
	     break;
	    default:
	    	System.out.println("no more that 3 pages");
	  }
		
	}

	
	public String getProductTitle(int index)
	{
		return products.get(index).findElement(titleProductLocator).getText();
	}
	
	public String getProductPrice(int index)
	{
		return products.get(index).findElement(priceProductLocator).getText();
	}
	
	public String getProductLink(int index)
	{
		return products.get(index).findElement(linkProductLocator).getAttribute("href");
	}
	
}
