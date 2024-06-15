package RahulShettyAcademy.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import RahulShettyAcademy.PageObjectModel.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage ;
	
	public WebDriver initializeDriver() throws IOException{
		
		
		
		Properties prop = new Properties(); // we are calling this Properties class becuase we need to invoke .Properties class(GlobalData.properties)
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\RahilShettyAcademy\\resources\\GlobalData.properties");
		//FileInputStream is called because properties class returns this method 
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}
		
		if(browserName.equalsIgnoreCase("edge")) {
			// Edge
		}
		
		if(browserName.equalsIgnoreCase("chrome")) {
			//firefox
		}
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
