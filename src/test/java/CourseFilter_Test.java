import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MainPage;
import java.time.LocalDate;

public class CourseFilter_Test extends BaseTest {
  @Test
  public void findCourse() {
    MainPage mainPage = new MainPage(driver);
    mainPage.open();
    System.out.println(mainPage.minDate().toString());
    System.out.println(mainPage.maxDate().toString());


  }
}
