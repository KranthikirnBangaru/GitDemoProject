package resturent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PSResturent {
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Lenovo/Desktop/Automation%20Testing/PSRestuarant/index.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li/a")).click();
		
		Set<String> windowId = driver.getWindowHandles();		// return Id's of Multiple browser windows.
		
		List<String> wlist = new ArrayList(windowId);
		String parentId = wlist.get(0);
		String childId = wlist.get(1);
		
		driver.switchTo().window(childId);
		System.out.println("Child Window : "+driver.getTitle());
		
		WebElement radio1 = driver.findElement(By.name("foodType"));
//		WebElement radio2 = driver.findElement(By.name("foodType"));
		radio1.click();
		System.out.println("Vegterian Item is Selected : "+radio1.isSelected());
		
		Select dropdown1 = new Select(driver.findElement(By.id("mainDish")));
		dropdown1.selectByIndex(4);
		
		Select dropdown2 = new Select(driver.findElement(By.id("curry")));
		dropdown2.selectByIndex(1);
		
		driver.findElement(By.name("username")).sendKeys("Kranthi Bangaru");
		Thread.sleep(300);
		driver.findElement(By.name("customerAddress")).sendKeys("H No: 254909, Kothapet(Astalaxmi Temple Beside), Hyderabad");
		Thread.sleep(300);
		driver.findElement(By.name("mobileno")).sendKeys("1234567891");
		Thread.sleep(300);
		driver.findElement(By.name("email")).sendKeys("kranthi2595@gmail.com");
		Thread.sleep(300);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[2]/form/div[8]/div/div[1]/div[2]/div/input")).sendKeys("25951101");
		Thread.sleep(300);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[2]/form/button")).click();
		
		String alertMessageveg= driver.switchTo().alert().getText();
		
		System.out.println(alertMessageveg);
		
		driver.switchTo().alert().accept();
		
		System.out.println("Order is Successfully Completed...");
		Thread.sleep(1000);
		
		System.out.println("Section change to Takeaway..");
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[2]/a")).click();
		
		WebElement radio2 = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/label[2]/input"));
		radio2.click();
		System.out.println("Non-Vegterian Item is Selected : "+radio2.isSelected());
		
		Select dropdown3 = new Select(driver.findElement(By.id("mainDish")));
		dropdown3.selectByIndex(2);
		
		Select dropdown4 = new Select(driver.findElement(By.id("curry")));
		dropdown4.selectByIndex(0);
		
		driver.findElement(By.name("msg")).sendKeys("1234567891");
		Thread.sleep(300);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/button")).click();
		Thread.sleep(300);
		String alertMessageNonveg= driver.switchTo().alert().getText();
		System.out.println(alertMessageNonveg);
		driver.switchTo().alert().accept();
		
		System.out.println("Order is Successfully Completed...");
		Thread.sleep(2000);
		
		System.out.println("Section change to Week-end Offers...");
		Thread.sleep(600);
		
		driver.findElement(By.linkText("Weekend Offers")).click();
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 try {
		        FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\Week-end offer1.png"));
		        } 
		 catch (IOException e) {
		            System.out.println(e.getMessage());
		        }
		 
		 Thread.sleep(600);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,800)");
		 
			File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 try {
			        FileUtils.copyFile(screenshot2, new File("C:\\projectScreenshots\\Week-end offer2.png"));
			        } 
			 catch (IOException e) {
			            System.out.println(e.getMessage());
			        }
		
			System.out.println("Week-End Offers is Completed...");
			Thread.sleep(2000);
				
			System.out.println("Section change to Gallery...");
			driver.findElement(By.linkText("Gallery")).click();
			Thread.sleep(2000);
			File File1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(File1,new File("C:\\projectScreenshots\\Nuggets.png"));
			Thread.sleep(7000);
			File File2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(File2,new File("C:\\projectScreenshots\\Meals.png"));
			Thread.sleep(7000);
			File File3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(File3,new File("C:\\projectScreenshots\\ChikenTikka.png"));
			Thread.sleep(7000);
			File File4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(File4,new File("C:\\projectScreenshots\\Pizza.png"));
			Thread.sleep(7000);
			
			System.out.println("Gallery is Successfully Completed...");
			Thread.sleep(2000);
			
			System.out.println("Section change to Contact Us...");
			
			driver.findElement(By.linkText("Contact Us")).click();
			
			Set<String> windowId2 = driver.getWindowHandles();	
			List<String> swlist = new ArrayList(windowId2);
			
			String schildId = swlist.get(2);
			
			System.out.println("Sub Child Id : "+schildId);
			
			driver.switchTo().window(schildId);
			System.out.println("Contact us Window : "+driver.getTitle());
			
			driver.findElement(By.name("username")).sendKeys("Kranthikiran");
			Thread.sleep(300);
			driver.findElement(By.name("useremail")).sendKeys("Kranthi2595@gmail.com");
			Thread.sleep(300);
			driver.findElement(By.name("mobilenumber")).sendKeys("9502188316");
			Thread.sleep(300);
			
			Select dropdown5 = new Select(driver.findElement(By.id("help")));
			dropdown5.selectByIndex(2);
			
			Thread.sleep(300);
			driver.findElement(By.name("userAddress")).sendKeys("Hotel Tabla, Miraj Theater Beside Kothapet, Hyderabad. ");
			Thread.sleep(300);
			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/button")).click();
			String alertMessagecontUs= driver.switchTo().alert().getText();
			System.out.println(alertMessagecontUs);
			driver.switchTo().alert().accept();
			System.out.println("Thank You for Visting.");
			Thread.sleep(100);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a")).click();
			Thread.sleep(200);
			driver.close();
			driver.quit();
			
	}

}
