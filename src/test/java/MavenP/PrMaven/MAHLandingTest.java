package MavenP.PrMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Utilities.Objprop;

public class MAHLandingTest extends BaseClassTest {

	@Test
	public void MAHOrder() throws Exception {
		Objprop obj = new Objprop();
		getBrowser().get(obj.getUrl());
		log.debug("Url Opened");
		getBrowser().manage().window().maximize();
		Thread.sleep(8000);
		Actions actions = new Actions(getBrowser());
		WebElement Emailfi = getBrowser().findElement(By.cssSelector(".row>div>div>input#email"));
		actions.moveToElement(Emailfi).click().sendKeys("abc@gmail.com").build().perform();
		Emailfi.clear();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getBrowser();
		js.executeScript("arguments[0].value='abc@gmail.com';", Emailfi);
		
		WebElement addFile = getBrowser().findElement(By.cssSelector(".input-file-container>div>div#file-attach>input#files"));
		actions.moveToElement(addFile).click().build().perform();
		Thread.sleep(5000);
		String path = System.getProperty("user.dir") + "\\ExFiles\\TestingDoc.docx";
		String FFile ="./ExFiles/MSGbox.exe";
		String arr[] = {FFile,path};
		Runtime.getRuntime().exec(arr);
	}
}
