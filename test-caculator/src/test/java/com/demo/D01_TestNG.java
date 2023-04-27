package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;


public class D01_TestNG {

	@Test
	public void shouldAdd2Nums() {
		Calculator calc = new Calculator();
		int actualResult = calc.add(5, 97);
		Assert.assertEquals(actualResult, 102);
	}
	
	@Test
	public void shouldAdd5Nums() {
		Calculator calc = new Calculator();
		int actualResult = calc.add(5, 5, 1, 4, 71);
		Assert.assertEquals(actualResult, 86);
	}
	
}
