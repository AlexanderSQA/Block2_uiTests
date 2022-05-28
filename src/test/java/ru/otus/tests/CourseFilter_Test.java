package ru.otus.tests;

import com.google.inject.Inject;
import org.testng.annotations.Test;
import pages.MainPage;

public class CourseFilter_Test extends BaseTest {
  @Inject
  private MainPage mainPage;

  @Test
  public void findCourse() {
    mainPage.open();
    System.out.println(mainPage.minDate().toString());
    System.out.println(mainPage.maxDate().toString());
  }
}
