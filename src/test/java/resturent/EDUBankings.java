package resturent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EDUBankings {
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Lenovo/Desktop/Automation%20Testing/PSRestuarant/index.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void customerlogin() {
		
	}

}
