package courses;

import java.time.Month;

public enum MonthDate {
  JANUARY("января", Month.JANUARY),
  FEBRUARY("февраля", Month.FEBRUARY),
  MARCH("марта", Month.MARCH),
  APRIL("апреля", Month.APRIL),
  MAY("мая", Month.MAY),
  JUNE("июня", Month.JUNE),
  JULY("июля", Month.JULY),
  AUGUST("августа", Month.AUGUST),
  SEPTEMBER("сентября", Month.SEPTEMBER),
  OCTOBER("октября", Month.OCTOBER),
  NOVEMBER("ноября", Month.NOVEMBER),
  DECEMBER("декабря", Month.DECEMBER);

  private final String name;
  private final Month month;

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
