package com.otus.steps;

import components.MainMenuComponent;
import data.SpecData;
import exceptions.DriverNotSupported;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pages.MainPage;
import webdriverfactory.WDFactory;
import java.util.Locale;

public class MainPageSteps {

  ApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  @Autowired
  private WebDriver driver;

  @Autowired
  private MainPage mainPage;


  @Before

  public void initDriver() {
    driver = new WDFactory().getDriver(System.getProperty("browser").toUpperCase(Locale.ROOT));
  }

  @After
  public void closeDriver() {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }

  @Пусть("^Открыта главная страница курса otus в браузере$")
  public void openMainPage() {
    mainPage.open();
  }

  @Тогда("Главная страница открыта и заголовок {string}")
  public void mainPageShouldBeOpened(String expectedHeader) {
    mainPage.mainBannerShouldBeHasHeader(expectedHeader);
  }

  @Если("Кликнуть на специализацию курса {string}")
  public void clickNavMenuItem(SpecData specData) {
    new MainMenuComponent(driver).checkOpenSpecPage(specData);
  }

}

