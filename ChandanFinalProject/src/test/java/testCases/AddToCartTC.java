package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddToCart;



public class AddToCartTC {
	
	WebDriver driver;
	AddToCart cart;

	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.stationerybazaar.com/index.php?main_page=index");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		cart= new AddToCart(driver);
	}

	@Test
	public void AddToCartProduct() throws IOException
	{
		cart.enterRequirement("Acrylic Pen Stand");
		cart.clickSearchBtn();
		cart.clickAddtoCartBtn();

		System.out.println("Add to Cart button clicked");


		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Chandan Project/img4.jpg");
		FileUtils.copyFile(source, dest);
		System.out.println("Screenshot Captured");
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}


	

}
