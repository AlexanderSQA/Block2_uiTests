package courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Courses {

  private String title;
  private String date;
  private Month month;

  public Courses(String title, String date, Month month) {
    this.title = title;
    this.date = date;
    this.month = month;
  }

  public String getTitle() {
    return title;
  }

  public String getDate() {
    return date;
  }

  public Month getMonth() {
    return month;
  }

  public void getCourse(){
    List<Courses> courses = new ArrayList<>(Arrays.asList(
        new Courses(title,date,month)
    ));
  }

}
