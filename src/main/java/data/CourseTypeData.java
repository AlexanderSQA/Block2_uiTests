package data;

public enum CourseTypeData {
  QA("Тестирование");

  private String name;

  CourseTypeData(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
