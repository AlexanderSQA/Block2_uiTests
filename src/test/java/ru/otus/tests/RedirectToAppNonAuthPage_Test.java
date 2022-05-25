package ru.otus.tests;

import data.PageData;
import org.testng.annotations.Test;
import pages.SpecData;
import pages.SpecPage;

public class RedirectToAppNonAuthPage_Test extends BaseTest {

  SpecPage specPage = new SpecPage(driver, SpecData.QA);


  @Test
  public void redirectToAuthFormIfNotLogin() {

    specPage.open()
        .clickAppButton()
        .clickRedirectButton(PageData.QA)
        .checkNonAuthPageTitle();
  }
}
