import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class Test1 {
	
	//static WebDriver driver;
	AppiumDriver driver;
	
	@Test
	public void testing() throws MalformedURLException {
		
		DesiredCapabilities cap =new DesiredCapabilities();
		cap.setCapability("deviceName", "Moto G Plus");
		cap.setCapability("udid", "ZY322L223D");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.1.0");
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");
				
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url =new URL("http://127.0.0.1:4723/wd/hub");
		driver=new AppiumDriver<WebElement>(url,cap);
		//driver=new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		driver.findElement(By.xpath("//android.view.ViewGroup//android.widget.Button[@resource-id='com.google.android.calculator:id/digit_8']")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup//android.widget.Button[@resource-id='com.google.android.calculator:id/digit_8']")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup//android.widget.Button[@content-desc='plus']")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup//android.widget.Button[@resource-id='com.google.android.calculator:id/digit_7']")).click();
		
		String test=driver.findElement(By.xpath("//android.view.ViewGroup//android.widget.Button[@resource-id='com.google.android.calculator:id/digit_7']")).getText();
				
		if(test.equalsIgnoreCase("95")) {
			
			System.out.println("Result is correct");
			
		}else
		{
			
			System.out.println("Result is incorrect");
		}
		
		System.out.println("Completed");
				
	}

}
