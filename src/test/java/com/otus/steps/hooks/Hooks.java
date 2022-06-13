package com.otus.steps.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.GuiceScoped;
import webdriverfactory.WDFactory;


public class Hooks {

  @Inject
  private GuiceScoped guiceScoped;
  @Inject
  private WDFactory driverFactory;


  @Before
  public void startUp() {
    guiceScoped.browserName = "chrome";
    guiceScoped.driver = driverFactory.getDriver();
    guiceScoped.wait = new WebDriverWait(guiceScoped.driver, 10);
  }

  @After
  public void close() {
    if (guiceScoped.driver != null) {
      guiceScoped.driver.close();
      guiceScoped.driver.quit();
    }
  }
}
