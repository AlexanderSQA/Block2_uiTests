package com.otus.steps;

import com.google.inject.Inject;
import com.otus.steps.hooks.Hooks;
import components.MainMenuComponent;
import data.SpecData;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SpecPage;

public class FindSpecPage_Test extends Hooks {
  @Inject
  private MainPage mainPage;
  @Inject
  private SpecPage specPage;
  @Inject
  private MainMenuComponent component;

  @Test
  public void navigateToJavaQaSpecPage() {

    mainPage.open();
    component.checkOpenSpecPage(SpecData.QA_AUTOMATION);

    specPage.checkRedirButtonText("Оставить заявку");

  }
}
