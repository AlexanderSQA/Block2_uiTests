package ru.otus.tests;

import data.PageData;
import org.testng.annotations.Test;
import pages.SpecPage;
import pages.SpecPageData;

public class RedirectToAppNonAuthPage_Test extends BaseTest {
  private SpecPage specPage = new SpecPage(driver, SpecPageData.QA);


  @Test
  public void redirectToAuthFormIfNotLogin() {

    specPage.open()
        .clickAppButton()
        .clickRedirectButton(PageData.QA)
        .checkNonAuthPageTitle();
  }
}
