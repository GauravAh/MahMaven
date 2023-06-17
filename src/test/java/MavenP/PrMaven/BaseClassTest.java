package MavenP.PrMaven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTest {
	
	static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger log;
	
	@BeforeTest
	public void setBrowser() {
		log= LogManager.getLogger(BaseClassTest.class.getName());
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
	}
	
	public WebDriver getBrowser() {
		return driver.get();
	}
	
	
	@AfterTest
	public void Quit() {
		// getBrowser().close();
	}

}
