package com.demo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class D02_TestNgHooks {
	Calculator calc;
	
	@BeforeMethod
	public void startUp() {
		calc = new Calculator();
	}
	@AfterMethod
	public void beforeEnd() {
		calc = null;
	}
	@Test
	public void shouldAdd2Nums() {
		
		int actualResult = calc.add(5, 97);
		Assert.assertEquals(actualResult, 102);
//		calc.close();
	}
	
	@Test
	public void shouldAdd5Nums() {
		
		int actualResult = calc.add(5, 5, 1, 4, 71);
		Assert.assertEquals(actualResult, 86);
//		calc.close();
	}
	
}
