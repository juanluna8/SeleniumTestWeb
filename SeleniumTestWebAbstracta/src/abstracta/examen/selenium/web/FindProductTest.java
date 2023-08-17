package abstracta.examen.selenium.web;


import java.io.FileWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import java.io.IOException;

public class FindProductTest {
	
	private WebDriver driver; 
	FindProductPage findProductPage;
	FileWriter archivo;
	int numberPagesToCheck;
	
	@Before
	public void setUp() throws Exception {
		findProductPage = new FindProductPage(driver);	
		driver = findProductPage.chromeDriver();
		findProductPage.visit("https://www.mercadolibre.com.ar");
		archivo = new FileWriter("./ProductosArchivo.txt");
		numberPagesToCheck = 3;
	}

	@After
	public void tearDown() throws Exception {
		archivo.close();
		driver.quit();
	}

	@Test
	public void test_FindProduct() throws InterruptedException, IOException {
		findProductPage.findProduct("camisetas");
		
		for(int i = 0; i< numberPagesToCheck; i++)
		{
			
			findProductPage.listProducts();

			writeFile();
		
			Thread.sleep(15000);
			findProductPage.goNextProductPage();
		}
		

		
	}
	
	public void writeFile() throws IOException
	{
		for (int i=0 ; i<findProductPage.products.size(); i++)
		{
				archivo.write(findProductPage.getProductTitle(i) + "\n" +
								findProductPage.getProductPrice(i) + "\n" +
								findProductPage.getProductLink(i) + "\n" +
								"---------------"+ "\n");
		}
	}

}
