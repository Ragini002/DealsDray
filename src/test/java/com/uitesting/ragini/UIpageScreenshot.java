package com.uitesting.ragini;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UIpageScreenshot{
	public static WebDriver driver;
	public static Dimension screenSize;
	
	
	@Parameters("browserName")
	@BeforeMethod
	public void preConditions(String browserName) throws InterruptedException {
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}//else if(browserName.equals("safari")) {
			//driver = new SafariDriver();
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.getcalley.com/page-sitemap.xml");
	}
	@AfterMethod
	public void postCondition(ITestResult result) throws IOException {
		 if(result.getStatus()==ITestResult.SUCCESS) {
		 String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		 Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
		 TakesScreenshot tss = (TakesScreenshot) driver;
		 File temp = tss.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./Desktop/"+resolution+"/"+timestamp+"screenshot.png");
		 FileUtils.copyFile(temp, dest);
		 }
		 driver.quit();
	}
	@Test(priority =1)
	public void clickOnFirstLink() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(text(),'https://www.getcalley.com/')]/../..)[1]")).click();
		Thread.sleep(5000);
		Assert.assertEquals("Calley Automatic Call Dialer For Android & IOS Phones",driver.getTitle(), "Page not found");
		Thread.sleep(5000);
	}
	@Test(priority =2)
	public void clickOnSecondLink() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(text(),'https://www.getcalley.com/')]/../..)[2]")).click();
		Thread.sleep(5000);
		Assert.assertEquals("Calley Call From Browser",driver.getTitle(), "Page not found");
		Thread.sleep(5000);
	}
	@Test(priority =3)
	public void clickOnThirdLink() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(text(),'https://www.getcalley.com/')]/../..)[3]")).click();
		Thread.sleep(5000);
		Assert.assertEquals("Best Automatic Calling App For Business Owners - Calley PRO",driver.getTitle(), "Page not found");
		Thread.sleep(5000);
	}
	@Test(priority =4)
	public void clickOnForthLink() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(text(),'https://www.getcalley.com/')]/../..)[4]")).click();
		Thread.sleep(5000);
		Assert.assertEquals("Calley Is The Best Auto Dialer App For Your Mobile Phone",driver.getTitle(), "Page not found");
		Thread.sleep(5000);
	}
	@Test(priority =5)
	
	public void clickOnFifthLink() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(text(),'https://www.getcalley.com/')]/../..)[5]")).click();
		Thread.sleep(5000);
		Assert.assertEquals("How Does Calley Best Free Automatic Call Dialer Works?",driver.getTitle(), "Page not found");
		Thread.sleep(5000);
	}
	
	
}