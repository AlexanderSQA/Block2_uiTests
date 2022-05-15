package courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import support.SpringScoped;

import java.util.List;


public class SpecializationCourse extends MainPage {

  @FindBy(css = ".container-padding-bottom .lessons__new-item-time")
  private List<WebElement> dateList;

  public SpecializationCourse(SpringScoped springScoped) {
    super(springScoped);
  }

  public List<WebElement> getDateList() {
    return dateList;
  }
}
