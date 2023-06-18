package MavenP.PrMaven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTest {
	
	static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger log;
	
	@Parameters("Browser")
	@BeforeTest
	public void setBrowser(String lBrowser) {
		if(lBrowser.equals("chrome")) {
		log= LogManager.getLogger(BaseClassTest.class.getName());
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		}
		else if(lBrowser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
	}
	
	public WebDriver getBrowser() {
		return driver.get();
	}
	
	
	@AfterTest
	public void Quit() {
		// getBrowser().close();
	}

}
