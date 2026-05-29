package com.testing.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class T2Logout {
	@Test
    public void logoutTest() {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // Login
        driver.findElement(By.id("inputUsername"))
              .sendKeys("rahul");

        driver.findElement(By.name("inputPassword"))
              .sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector(".signInBtn"))
              .click();

        // Wait until login success page appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[text()='Log Out']")));

        // Print success message
        System.out.println(
                driver.findElement(By.tagName("p")).getText());

        // Logout
        driver.findElement(By.xpath("//button[text()='Log Out']"))
              .click();

        // Validate returned to login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("inputUsername")));

        System.out.println("Logout successful");

        driver.quit();
    }
}
