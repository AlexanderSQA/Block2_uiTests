import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.MainPage;

public class CourseFilter_Test extends BaseTest {
  @Test
  public void findCourse() {
    MainPage mainPage = new MainPage(driver);
    mainPage.open();
    for(WebElement element : mainPage.collectValidDateList()){
      System.out.println(element.getText() + "   " + element);
    }

  }
}
