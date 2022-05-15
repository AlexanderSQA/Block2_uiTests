package com.otus.steps;

import components.MainMenuComponent;
import exceptions.DriverNotSupported;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pages.MainPage;
import webdriverfactory.WDFactory;
import java.util.Locale;

public class MainPageSteps {

  ApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  private WebDriver driver = null;
  private MainPage mainPage = context.getBean(MainPage.class);


  @Before
  public void initDriver() throws DriverNotSupported {
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
  public void mainPageShouldBeOpened(String expectedHeader){
    mainPage.mainBannerShouldBeHasHeader(expectedHeader);
  }

  @Если("Кликнуть на специализацию курса {string}")
  public void clickNavMenuItem(String itemMenu){
    new MainMenuComponent(driver, ).checkOpenSpecPage(itemMenu);
  }

}

