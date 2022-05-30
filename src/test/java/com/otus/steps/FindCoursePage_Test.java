package com.otus.steps;

import com.google.inject.Inject;
import components.MainMenuComponent;
import io.cucumber.java.ru.Если;
import pages.MainPage;
import pages.SpecPage;

public class FindCoursePage_Test {
  @Inject
  private MainPage mainPage;
  @Inject
  private SpecPage specPage;
  @Inject
  private MainMenuComponent component;

  @Если()
}
