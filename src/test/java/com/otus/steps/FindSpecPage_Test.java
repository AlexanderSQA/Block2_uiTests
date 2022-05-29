package com.otus.steps;

import com.google.inject.Inject;
import components.MainMenuComponent;
import pages.MainPage;
import pages.SpecPage;

public class FindSpecPage_Test {
  @Inject
  private MainPage mainPage;
  @Inject
  private SpecPage specPage;
  @Inject
  private MainMenuComponent component;

  //  @Test
  //  public void navigateToJavaQaSpecPage() {
  //
  //    mainPage.open();
  //    component.checkOpenSpecPage(SpecData.QA_AUTOMATION);
  //
  //    specPage.checkRedirButtonText("Оставить заявку");
  //
  //  }
}
