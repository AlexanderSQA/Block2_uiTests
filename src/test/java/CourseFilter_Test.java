import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.MainPage;

public class CourseFilter_Test extends BaseTest {
  @Autowired
  private MainPage mainPage;

  @Test
  public void findCourse() {

    mainPage.open();
    System.out.println(mainPage.minDate().toString());
    System.out.println(mainPage.maxDate().toString());


  }
}
