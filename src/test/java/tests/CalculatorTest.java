package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.calculator.net/");

        // Explicit Wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void additionTest() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='2']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='+']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='3']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='=']"))).click();

        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sciOutPut"))).getText();

        System.out.println("Result: " + result);

        Assert.assertTrue(result.contains("5"));
    }

    @AfterClass
    public void closeBrowser() {

        driver.quit();
    }
}