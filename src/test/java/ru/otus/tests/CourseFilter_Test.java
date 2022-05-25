package ru.otus.tests;

import org.testng.annotations.Test;
import pages.MainPage;

public class CourseFilter_Test extends BaseTest {

  MainPage mainPage = new MainPage(driver);

  @Test
  public void findCourse() {
    mainPage.open();
    System.out.println(mainPage.minDate().toString());
    System.out.println(mainPage.maxDate().toString());
  }
}
