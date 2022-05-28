package ru.otus.tests;

import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import support.GuiceScoped;
import webdriverfactory.WDFactory;
import java.util.Locale;


public class BaseTest {
  //  @Inject
  //  protected WebDriver driver;
  @Inject
  protected WebDriverWait wait;
  @Inject
  protected Actions actions;
  @Inject
  protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);
  @Inject
  private GuiceScoped guiceScoped;


  @BeforeMethod(alwaysRun = true)
  public void setupWebDriver() {
    System.out.println("CHECK EXECUTING METHOD");
    guiceScoped.driver = new WDFactory(guiceScoped).getDriver();
    wait = new WebDriverWait(guiceScoped.driver, 4);
    actions = new Actions(guiceScoped.driver);
  }

  @AfterMethod
  public void close() {
    if (guiceScoped.driver != null) {
      guiceScoped.driver.close();
      guiceScoped.driver.quit();
    }
  }
}
