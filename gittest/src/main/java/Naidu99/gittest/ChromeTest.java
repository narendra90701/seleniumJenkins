package Naidu99.gittest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeTest {
	
	static WebDriver driver=null;
  @Test
  public void verifyKit() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		
		//Open chrome Browser
		driver= new ChromeDriver();
		
		// delete cache and cookies
		driver.manage().deleteAllCookies();
		
		// maximize the browser
		
		driver.manage().window().maximize();
		
		//Hit the url
		driver.get("http://www.sheercover.com");
		
		// validate the Destination page title
		
		String expHomePageTitle="Mineral Makeup from Sheer Cover Studio | Official Site";
		String actHomePageTitle=driver.getTitle();
		
		if(actHomePageTitle.contentEquals(expHomePageTitle)) {
			System.out.println("Home page Title matches: Pass");
		}
		else {
			System.out.println("Home page Title mismatches: fail");
			
		}
		
		// Verify Home page Order now button display
		
		if (driver.findElement(By.xpath("//*[@id=\"acq-brand-navigation\"]/ul/li[7]/a/div")).isDisplayed()) {
			
			System.out.println("Home page Order Now Btn: Displayed");
			// Click on Order Btn
			driver.findElement(By.xpath("//*[@id=\"acq-brand-navigation\"]/ul/li[7]/a/div")).click();
			
			// Print the Title in the console
			System.out.println(driver.getTitle());
			
			// verify the the Kit header text
			
			String expHeaderText="Mineral Makeup Kit Plus Skincare"; 
				
			String actHeaderText=driver.findElement(By.xpath("//*[@id=\"kit\"]/div[3]/div[2]/div[1]/div/div[1]/div/div/div[2]/div[2]")).getText();
			
			if (actHeaderText.contentEquals(expHeaderText)) {
				
				System.out.println("Header text matches");
				driver.findElement(By.xpath("//*[@id=\"kit\"]/div[3]/div[2]/div[1]/div/div[1]/div/div/div[2]/div[2]")).click();
				
				System.out.println(driver.findElement(By.xpath("//*[@id=\"inlinecart-wrapper\"]/div[2]/div/div[2]/div[2]/div[2]")).getText());
			}
			
			else {
				
				System.out.println("Header text mismatches");
			}
		}
		
		else {
			
			System.out.println("Home page Order Now Btn: Not Displayed");
		}
		
		
		System.out.println("**************** Closing Driver****************");
		driver.close();
		
		
	}
	  
	  
	  
  }

