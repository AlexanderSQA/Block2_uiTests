package com.otus.steps.hooks;

import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.GuiceScoped;
import webdriverfactory.WDFactory;


public class Hooks {

  protected WebDriverWait wait;
  protected Actions actions;
  @Inject
  private GuiceScoped guiceScoped;

  @Before
  public void setupWebDriver() {
    guiceScoped.driver = new WDFactory(guiceScoped).getDriver();
    wait = new WebDriverWait(guiceScoped.driver, 4);
    actions = new Actions(guiceScoped.driver);
  }

  @After
  public void close() {
    if (guiceScoped.driver != null) {
      guiceScoped.driver.close();
      guiceScoped.driver.quit();
    }
  }
}
