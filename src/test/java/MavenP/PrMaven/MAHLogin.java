package MavenP.PrMaven;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.DataDriven;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MAHLogin {
	WebDriver driver;
	
	@BeforeTest
	public void mahBrowser() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://myassignmenthelp.com/Home/forgot.php");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	@Test
	public void mahForget() throws Exception {
		String path ="./ExFiles/AmazonExcel.xlsx";
		DataDriven dd = new DataDriven(path);
		HashMap<String, String> ddMap = dd.readHashmap("Amazon");
		
		for(Entry<String, String> nMap :ddMap.entrySet()) {
			System.out.println("Value is.." + nMap);
			driver.findElement(By.cssSelector(".p-relative>input#txtEmail")).sendKeys(nMap.getValue());
		}
	}

}
