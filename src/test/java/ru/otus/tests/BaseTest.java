package ru.otus.tests;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webdriverfactory.WDFactory;


public class BaseTest {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Actions actions;
  protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);


  @BeforeMethod
  public void setupWebDriver() {
    WDFactory wdFactory = new WDFactory();
    driver = wdFactory.getDriver();
    wait = new WebDriverWait(driver, 4);
    actions = new Actions(driver);
  }

  @AfterMethod
  public void close() {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }
}
