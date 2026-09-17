package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Disabled;

class AuthTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void shouldLoginSuccessfully() {
        driver.get("https://seleniumbase.io/simple/login");

        driver.findElement(By.id("username"))
              .sendKeys("demo_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_pass");

        driver.findElement(By.id("log-in"))
              .click();

        String heading = driver.findElement(By.tagName("h1"))
                               .getText();

        assertEquals("Welcome!", heading);
    }
    @Test
    void shouldLoginRequirUser() {
        driver.get("https://seleniumbase.io/simple/login");

        driver.findElement(By.id("log-in"))
              .click();

        String heading = driver.findElement(By.tagName("h6"))
                               .getText();

        assertEquals("The Username is Required!", heading);
    }

    @Test
    void shouldLoginRequirPassword() {
        driver.get("https://seleniumbase.io/simple/login");

        driver.findElement(By.id("username"))
              .sendKeys("demo_user");

        driver.findElement(By.id("log-in"))
              .click();

        String heading = driver.findElement(By.tagName("h6"))
                               .getText();

        assertEquals("The Password is Required!", heading);
    }
    @Disabled
    void UsernameWrong() {
        driver.get("https://seleniumbase.io/simple/login");

        driver.findElement(By.id("username"))
              .sendKeys("demo_user1");

        driver.findElement(By.id("log-in"))
              .click();

        String heading = driver.findElement(By.tagName("h6"))
                               .getText();

        assertEquals("Invalid Username!", heading);
    }
}