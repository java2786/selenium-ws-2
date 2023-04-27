package com.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class D03_SeleniumTest {

	WebDriver driver = null;
	
	@AfterMethod
	public void beforeEnd() {
		driver = null;
	}
	
	@BeforeMethod
	public void createDriver() {
		switch(Inputs.BROWSER){
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "ff":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
			default:
				driver = new ChromeDriver();
		}
	}
	
	@Test
	public void shouldOpenWebPage() throws InterruptedException {
		driver.get(Inputs.URL);
		
		Thread.sleep(2000);
		driver.quit();
	}

	
	@Test
	public void shouldMulNums() throws InterruptedException {
		driver.get(Inputs.URL);
		
		// find element 1
		WebElement input1 = driver.findElement(By.xpath("/html/body/div/div/form/input[1]"));
		// enter num
		input1.sendKeys(Inputs.NUM1);
				
		// find element 2
		// enter num
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys(Inputs.NUM2);
		
		// find dropdown
		WebElement selectElement = driver.findElement(By.xpath("/html/body/div/div/form/select"));
		// select operation
		List<WebElement> options = selectElement.findElements(By.tagName("option"));
		
		for(WebElement option:options) {
			if(option.getText().equals(Inputs.OPERATION)) {
				option.click();
				break;
			}
		}
		
		// find go button
		// click
		driver.findElement(By.xpath("//*[@id=\"gobutton\"]")).click();
		
		Thread.sleep(2000);
		
		// verify if result shown is correct
		String actualResult = driver.findElement(By.xpath("/html/body/div/div/form/h2")).getText();
		Assert.assertEquals(actualResult, Inputs.RESULT);
		
		driver.quit();
	}

	@Test
	public void shouldAddNums() throws InterruptedException {
		driver.get(Inputs.URL);
		
		// find element 1
		WebElement input1 = driver.findElement(By.xpath("/html/body/div/div/form/input[1]"));
		// enter num
		input1.sendKeys(Inputs.NUM1);
				
		// find element 2
		// enter num
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).sendKeys(Inputs.NUM2);
		
		// find dropdown
		WebElement selectElement = driver.findElement(By.xpath("/html/body/div/div/form/select"));
		// select operation
		List<WebElement> options = selectElement.findElements(By.tagName("option"));
		
		for(WebElement option:options) {
			if(option.getText().equals("+")) {
				option.click();
				break;
			}
		}
		
		// find go button
		// click
		driver.findElement(By.xpath("//*[@id=\"gobutton\"]")).click();
		
		Thread.sleep(2000);
		
		// verify if result shown is correct
		String actualResult = driver.findElement(By.xpath("/html/body/div/div/form/h2")).getText();
		Assert.assertEquals(actualResult, "30");
		
		driver.quit();
	}

}
