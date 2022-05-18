import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import pages.MainPage;

public class CourseFilter_Test extends BaseTest {
  //  ApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  private MainPage mainPage = context.getBean(MainPage.class);

  @Test
  public void findCourse() {

    mainPage.open();
    System.out.println(mainPage.minDate().toString());
    System.out.println(mainPage.maxDate().toString());


  }
}
