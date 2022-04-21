package courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;

import java.util.List;


public class SpecializationCourse extends MainPage {

  @FindBy(css = ".container-padding-bottom .lessons__new-item-time")
  private List<WebElement> dateList;

  public SpecializationCourse(WebDriver driver) {
    super(driver);
  }

  public List<WebElement> getDateList() {
    return dateList;
  }
}
