package courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import java.util.List;

public class FavoriteCourse extends MainPage {

  @FindBy(css = ".lessons__new-item-start")
  private List<WebElement> dateList;

  public FavoriteCourse(WebDriver driver) {
    super(driver);
  }


  public List<WebElement> getDateList() {
    return dateList;
  }
}
