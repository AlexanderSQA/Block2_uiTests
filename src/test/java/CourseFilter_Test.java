import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.MainPage;

public class CourseFilter_Test extends BaseTest {
  @Autowired
  private MainPage mainPage;
  //  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("CourseFilter_Test.java");
  //  MainPage mainPage = context.getBean(MainPage.class);

  @Test
  public void findCourse() {

    mainPage.open();
    System.out.println(mainPage.minDate().toString());
    System.out.println(mainPage.maxDate().toString());


  }
}
