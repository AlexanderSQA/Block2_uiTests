package com.otus.steps;

import com.google.inject.Inject;
import components.MainMenuComponent;
import courses.TrainingCourses;
import io.cucumber.java.ru.����;
import io.cucumber.java.ru.�����;

public class TrainingCoursesSteps {

  @Inject
  private TrainingCourses trainingCourses;
  @Inject
  private MainMenuComponent mainMenuComponent;


  @����("������� ��������� ���������������� ������")
  public void openTrainingCoursesPage(){
    mainMenuComponent.openTrainingCoursePage();
  }

  @�����("������ ����� ������� � ����� ������� �����")
  public void getBounderyCostOfCourses(){

  }
}
