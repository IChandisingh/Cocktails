package com.indiana.chandisingh.springboottrail;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.jupiter.api.Disabled;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
@Disabled
public class GarnishEntryTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void garnishEntry() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(909, 1040));
    driver.findElement(By.linkText("Garnish")).click();
    driver.findElement(By.id("gname")).click();
    driver.findElement(By.id("gname")).sendKeys("name");
    driver.findElement(By.id("gtype")).click();
    driver.findElement(By.id("gtype")).sendKeys("type");
    driver.findElement(By.id("gstorage")).click();
    driver.findElement(By.id("gstorage")).sendKeys("storage");
    driver.findElement(By.id("gbtn")).click();
  }
}
