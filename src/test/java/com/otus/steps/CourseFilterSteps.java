package com.otus.steps;

import com.google.inject.Inject;
import com.otus.steps.hooks.Hooks;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;
import support.GuiceScoped;
import webdriverfactory.WDFactory;


public class CourseFilterSteps {
  @Inject
  private MainPage mainPage;
  @Inject
  private GuiceScoped guiceScoped;
  @Inject
  private WDFactory driverFactory;

  //  @Test
  //  public void findCourse() {
  //    mainPage.open();
  //    System.out.println(mainPage.minDate().toString());
  //    System.out.println(mainPage.maxDate().toString());
  //  }

  @Пусть("^Открыта главная страница курса otus в браузере$")
  public void openMainPage() {
    guiceScoped.browserName = "chrome";
    guiceScoped.driver = driverFactory.getDriver();
    mainPage.open();
  }

  @Тогда("Главная страница открыта и заголовок {string}")
  public void pageShouldBeOpened(String expectedHeader) {
    mainPage.mainBannerShouldBeHasHeader(expectedHeader);
  }
}
