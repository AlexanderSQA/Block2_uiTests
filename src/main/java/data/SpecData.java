package data;

public enum SpecData {
  QA_AUTOMATION("Специализация QA Automation Engineer", CourseTypeData.QA);

  private String subMenuName;
  private CourseTypeData typeData;

  SpecData(String subMenuName, CourseTypeData typeData) {
    this.subMenuName = subMenuName;
    this.typeData = typeData;
  }

  public String getSubMenuName() {
    return subMenuName;
  }

  public CourseTypeData getTypeData() {
    return typeData;
  }
}
