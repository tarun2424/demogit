package pkg1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossBrowser {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Soft_Dumps\\Selenium\\support\\new\\geckodriver.exe");
		    driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Soft_Dumps\\Selenium\\support\\new\\chromedriver.exe");
		     driver=new ChromeDriver();
		}
		
/*		else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:/Soft_Dumps/Selenium/support/new/IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}*/
		
		else {
			throw new Exception("Browser is not correct");
		}
	}
	
	
	@Test
	
	public void demo() throws InterruptedException {
		
		driver.get("https://petstore.octoperf.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Enter the Store")).click();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Sign")).click();
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tarun");
	//	driver.findElement(By.xpath("//input[contains(@id,'ripe')]")).sendKeys("tarun");
		driver.findElement(By.cssSelector("[id*=stripe]")).sendKeys("tarun");
		driver.findElement(By.name("password")).clear();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("itc@1234");
		driver.findElement(By.name("signon")).click();
		
		driver.quit();
	}

}
