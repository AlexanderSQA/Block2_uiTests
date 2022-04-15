package courses;

import java.time.LocalDate;
import java.time.Month;

public enum MonthDate {
  JANUARY("января", Month.JANUARY),
//  FEBRUARY,
//  МАРТ,
  APRIL("апреля", Month.APRIL),
//  МАЙ,
//  ИЮНЬ,
//  ИЮЛЬ,
//  АВГУСТ,
//  СЕНТЯБРЬ,
//  ОКТЯБРЬ,
//  НОЯБРЬ,
  DECEMBER("декабря", Month.DECEMBER);

  private String name;
  private Month month;

  MonthDate(String name, Month month) {
    this.name = name;
    this.month = month;
  }

  public String getName() {
    return name;
  }

  public Month getMonth() {
    return month;
  }
}
