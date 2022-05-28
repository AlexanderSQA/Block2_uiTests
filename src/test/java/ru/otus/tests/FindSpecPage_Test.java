package ru.otus.tests;

import com.google.inject.Inject;
import components.MainMenuComponent;
import data.SpecData;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SpecPage;
import pages.SpecPageData;

public class FindSpecPage_Test extends BaseTest {
  @Inject
  MainPage mainPage;
  @Inject
  SpecPage specPage;
  @Inject
  MainMenuComponent component;

  @Test
  public void navigateToJavaQaSpecPage() {

    mainPage.open();
    component.checkOpenSpecPage(SpecData.QA_AUTOMATION);

    specPage.checkRedirButtonText("Оставить заявку");

  }
}
