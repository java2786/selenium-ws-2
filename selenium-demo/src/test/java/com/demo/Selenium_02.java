package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Selenium_02 {

	public void shouldAdd2num() {

		String browser = Constants.BROWSER;

		WebDriver driver = selectBrowser(browser);

		driver.get(Constants.URL);
		driver.manage().window().maximize();
		
		WebElement inputElement1 = driver.findElement(By.className("input-small"));
		inputElement1.sendKeys(Constants.NUM1);
		
		WebElement inputElement2 = driver.findElement(By.xpath("/html/body/div/div/form/input[2]"));
		inputElement2.sendKeys(Constants.NUM2);
				
		WebElement selectElement = driver.findElement(By.xpath("/html/body/div/div/form/select"));
		
		WebElement option = selectElement.
				findElement(
						By.xpath("//option[@value='"+Constants.ADD+"']"));
		option.click();
		
		
		driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
		
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement resultElement = driver.findElement(By.xpath("/html/body/div/div/form/h2"));
		resultElement.getText();
		Assertions.assertTrue
		
		
		// assertions

		driver.quit();
	}

	private static WebDriver selectBrowser(String browser) {
		switch (browser) {
			case "edge":
				return new EdgeDriver();
			case "chrome":
				return new ChromeDriver();
			case "firefox":
				return new FirefoxDriver();
			case "ie":
				return new InternetExplorerDriver();
	
			default:
				return new FirefoxDriver();
		}

	}

}
