package com.magnus.day30;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverExample extends BaseClass {
	@BeforeTest()
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void performGoogleSearch() throws InterruptedException {
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Iphone 14" + Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("Iphone 12"));

	}

	@Test
	public void performWikiSearch() throws InterruptedException {
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Iphone 13" + Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("Iphone 13"));
		Reporter.log("Iphone 13 search completed successfully");
	}

	@AfterTest

	public void dismiss() {
		driver.close();
		driver.quit();
	}

}
