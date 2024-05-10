package com.uitesting.ragini;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(3000);
		driver.get("https://demo.dealsdray.com/");
		Thread.sleep(3000);
		WebElement unTF = driver.findElement(By.name("username"));
		Thread.sleep(3000);
		unTF.sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(3000);
		WebElement pwdTF = driver.findElement(By.name("password"));
		Thread.sleep(3000);
		pwdTF.sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'MuiButton-root MuiButton-contained')]")).submit();		
		WebElement Arrow = driver.findElement(By.xpath("//span[text()='chevron_right']"));
		Thread.sleep(3000);
		Arrow.click();
		Thread.sleep(3000);		
		WebElement orders = driver.findElement(By.xpath("//span[text()='Orders']"));
		Thread.sleep(3000);
		orders.click();
		Thread.sleep(3000);
		WebElement AddBulkorders = driver.findElement(By.xpath("//button[contains(@class,'MuiButton-root MuiButton-contained')]"));
		Thread.sleep(3000);
		AddBulkorders.click();
		Thread.sleep(3000);
		WebElement Choosefilelink = driver.findElement(By.xpath("//input[contains(@class,'MuiOutlinedInput-input MuiInputBase')]"));
		String filepath= "C:/Users/91843/OneDrive/Desktop/demo-data.xlsx";
		// String filepath= "C://Users//HP//Desktop//demo-data.xlsx";
		Choosefilelink.sendKeys(filepath);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[contains(@class,'MuiButton-root MuiButton-contained MuiButton')])[2]")).click();
		Thread.sleep(3000);
		//driver.quit();
	}
	

}
