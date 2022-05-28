package ru.otus.tests;

import com.google.inject.Inject;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageOpen_Test extends BaseTest {
  @Inject
  MainPage mainPage;

  @Test
  public void checkOpeningMainPage() {
    mainPage.open()
        .mainBannerShouldBeHasHeader("Авторские онлайн‑курсы для профессионалов");
  }
}
