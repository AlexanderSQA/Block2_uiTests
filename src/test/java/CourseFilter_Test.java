import org.testng.annotations.Test;
import pages.MainPage;

public class CourseFilter_Test extends BaseTest {
  @Test
  public void findCourse() {
    MainPage mainPage = new MainPage(driver);
    mainPage.open();
    mainPage.waitUntilLessonsDateBeVisible();
    mainPage.minDate();
    mainPage.maxDate();
  }
}
