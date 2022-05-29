package com.otus.steps;

import com.google.inject.Inject;
import com.otus.steps.hooks.Hooks;
import data.PageData;
import org.testng.annotations.Test;
import pages.SpecPage;

public class RedirectToAppNonAuthPage_Test extends Hooks {
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
