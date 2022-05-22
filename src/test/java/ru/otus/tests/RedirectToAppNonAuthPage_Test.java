package ru.otus.tests;

import data.PageData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SpecPage;

public class RedirectToAppNonAuthPage_Test extends BaseTest {
  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  private SpecPage specPage = context.getBean(SpecPage.class);


  @Test
  public void redirectToAuthFormIfNotLogin() {

    specPage.open()
        .clickAppButton()
        .clickRedirectButton(PageData.QA)
        .checkNonAuthPageTitle();
  }
}
