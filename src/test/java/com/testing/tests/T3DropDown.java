package com.testing.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class T3DropDown {

	@Test
    public void dropDownStaticCurrency() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		//Select tag is a sStatic kind of dropdown
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.close();
	}
    
    @Test
	public void dropDownStaticPassengers() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		for(int i=0;i<4;i++) { //Click i no. of Adult can be varied by user
			driver.findElement(By.id("hrefIncAdt")).click();
			Thread.sleep(1000);
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		}
		int child = 1;
		while(child < 3) {
			driver.findElement(By.xpath("//*[@id=\"hrefIncChd\"]")).click();
			Thread.sleep(1000);
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			child++;
		}
		int infant = 1;
		while(infant < 3) {
			driver.findElement(By.id("hrefIncInf")).click();
			Thread.sleep(1000);
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			infant++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
	}
    
	@Test
    public void dropDownDynamicDepartureCty() {
    	
    }
}
