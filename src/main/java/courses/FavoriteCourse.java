package courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import support.SpringScoped;
import java.util.List;

public class FavoriteCourse extends MainPage {

  @FindBy(css = ".lessons__new-item-start")
  private List<WebElement> dateList;

  public FavoriteCourse(SpringScoped springScoped) {
    super(springScoped);
  }


  public List<WebElement> getDateList() {
    return dateList;
  }
}
