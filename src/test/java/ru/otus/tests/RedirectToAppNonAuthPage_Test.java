package ru.otus.tests;

import com.google.inject.Inject;
import data.PageData;
import org.testng.annotations.Test;
import pages.SpecPage;
import pages.SpecPageData;

public class RedirectToAppNonAuthPage_Test extends BaseTest {
  @Inject
  private SpecPage specPage;


  @Test
  public void redirectToAuthFormIfNotLogin() {

    specPage.open()
        .clickAppButton()
        .clickRedirectButton(PageData.QA)
        .checkNonAuthPageTitle();
  }
}
