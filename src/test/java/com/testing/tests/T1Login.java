package com.testing.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class T1Login {

    @Test
    public void loginTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // Click Forgot Password
        driver.findElement(By.linkText("Forgot your password?")).click();

        // Fill reset password form
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("name");

        driver.findElement(By.xpath("//input[@placeholder='Email']"))
              .sendKeys("test@gmail.com");

        driver.findElement(By.xpath("//input[@placeholder='Phone Number']"))
              .sendKeys("1234567890");

        Thread.sleep(2000);

        // Click Reset Login
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        // Capture password text
        String passwordText =
                driver.findElement(By.cssSelector("form p")).getText();

        System.out.println(passwordText);

        // Extract password
        String password = getPassword(passwordText);

        System.out.println("Extracted Password: " + password);

        Thread.sleep(2000);
        // Go back to login
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();

        // Login
        driver.findElement(By.id("inputUsername"))
              .sendKeys("rahul");

        driver.findElement(By.name("inputPassword"))
              .sendKeys(password);
        
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".signInBtn")).click();

        // Validate successful login
        System.out.println(
                driver.findElement(By.tagName("p")).getText());

        driver.quit();
    }

    // Method to extract password
    public String getPassword(String passwordText) {

        String[] passwordArray = passwordText.split("'");

        String password = passwordArray[1];

        return password;
    }
}

