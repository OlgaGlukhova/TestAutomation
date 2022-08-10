package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://market.yandex.ru/");
            Thread.sleep (2000);
            WebElement input = driver.findElement(By.xpath("//input[@placeholder]"));
            input.sendKeys("Sony playstation ps5", Keys.ENTER);

            WebElement filterprice = driver.findElement(By.xpath("//button[@data-autotest-id=\"dprice\"]"));
            filterprice.click();
            List<WebElement> elements = driver.findElements(By.xpath("//h3[@data-tid-prop=\"1410220a\"]"));
            String text = elements.get(0).getText();
            System.out.println(text);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
        }
    }
