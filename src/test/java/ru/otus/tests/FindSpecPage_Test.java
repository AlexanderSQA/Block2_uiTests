package ru.otus.tests;

import components.MainMenuComponent;
import data.SpecData;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SpecPage;

public class FindSpecPage_Test extends BaseTest {

  MainPage mainPage = new MainPage(driver);
  SpecPage specPage = new SpecPage(driver, pages.SpecData.QA);
  MainMenuComponent component = new MainMenuComponent(driver, actions);

  @Test
  public void navigateToJavaQaSpecPage() {

    mainPage.open();
    component.checkOpenSpecPage(SpecData.QA_AUTOMATION);

    specPage.checkRedirButtonText("Оставить заявку");

  }
}
