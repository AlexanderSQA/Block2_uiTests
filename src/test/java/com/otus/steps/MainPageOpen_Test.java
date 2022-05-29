package com.otus.steps;

import com.google.inject.Inject;
import com.otus.steps.hooks.Hooks;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageOpen_Test extends Hooks {
  @Inject
  private MainPage mainPage;

  @Test
  public void checkOpeningMainPage() {
    mainPage.open()
        .mainBannerShouldBeHasHeader("Авторские онлайн‑курсы для профессионалов");
  }
}
