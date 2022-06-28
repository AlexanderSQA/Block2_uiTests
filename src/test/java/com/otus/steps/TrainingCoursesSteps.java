package com.otus.steps;

import com.google.inject.Inject;
import components.MainMenuComponent;
import courses.TrainingCourses;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;

public class TrainingCoursesSteps {

  @Inject
  private TrainingCourses trainingCourses;
  @Inject
  private MainMenuComponent mainMenuComponent;


  @Если("Выбрать категорию подготовительных курсов")
  public void openTrainingCoursesPage() {
    mainMenuComponent.openTrainingCoursePage();
  }

  @Тогда("Найден самый дешевый и самый дорогой курсы")
  public void getBounderyCostOfCourses() {
    System.out.println(trainingCourses.getTitleCourseWithMinCost());
    System.out.println(trainingCourses.getTitleCourseWithMaxCost());

  }
}
