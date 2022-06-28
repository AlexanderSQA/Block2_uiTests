package com.otus.steps;

import com.google.inject.Inject;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FindCoursePage_Test {
  @Inject
  private MainPage mainPage;

  @ParameterType("\\d{2}\\.\\d{2}\\.\\d{4}")
  public LocalDate myDate(String dateString) {
    return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
  }

  @Тогда("Выбрать найденный курс который содержит имя {string}")
  public void finderCourseByTitle(String courseTitle) {
    mainPage.clickOnCourseContainTitle(courseTitle);
  }

  @Если("Найдены курсы стартующие в указанную или после указанной даты {myDate}")
  public void findCoursesAfterDate(LocalDate localDate) {
    mainPage.getCourseAfterDate(localDate);
  }
}
