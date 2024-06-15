package RahulShettyAcademy.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettyAcademy.PageObjectModel.CartPage;
import RahulShettyAcademy.PageObjectModel.LandingPage;
import RahulShettyAcademy.PageObjectModel.ProductCatalogue;
import RahulShettyAcademy.TestComponent.BaseTest;

public class StandAloneTest_POMReference extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		// WeDriverManager.chromedriver().setup();

		String item = "ZARA COAT 3";
		String country = "india";

		LandingPage LandingPage = launchApplication();

		LandingPage.loginApplication("ayushs7598@gmail.com", "Ayush1234");

		ProductCatalogue pc = new ProductCatalogue(driver);
		List<WebElement> products = pc.getProductList();


		pc.addProductToCart(item);

		pc.addToCartPage();

		CartPage cp = new CartPage(driver);
		Boolean match = cp.cartItemsAvailable(item);
		Assert.assertTrue(match);
		cp.checkOut(country);

		String confirmationMessage = cp.confirmationPage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		//driver.close();
	}

}
