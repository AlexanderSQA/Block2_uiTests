package ru.otus.tests;

import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageOpen_Test extends BaseTest {

  MainPage mainPage = new MainPage(driver);

  @Test
  public void checkOpeningMainPage() {
    mainPage.open()
        .mainBannerShouldBeHasHeader("Авторские онлайн‑курсы для профессионалов");
  }
}
