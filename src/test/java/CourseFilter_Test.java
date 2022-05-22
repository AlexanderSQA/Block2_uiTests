import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import pages.MainPage;
import support.SpringConfig;

public class CourseFilter_Test extends BaseTest {
  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

  private MainPage mainPage = context.getBean("mainPage", MainPage.class);

  @Test
  public void findCourse() {

    mainPage.open();
    System.out.println(mainPage.minDate().toString());
    System.out.println(mainPage.maxDate().toString());


  }
}
