package com.otus.steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;
import java.time.LocalDate;

public class FindCoursePage_Test {
  @Inject
  private MainPage mainPage;


  @Тогда("Выбрать найденный курс который содержит имя {string}")
  public void finderCourseByTitle(String courseTitle) {
    mainPage.clickOnCourseContainTitle(courseTitle);
  }

//    @Если("Найдены курсы стартующие в указанную или после указанной {string}")
//    public void findCourseAfterTitle(LocalDate localDate){
//      mainPage.findCourseStartingAfterDate(localDate);
//    }
}
