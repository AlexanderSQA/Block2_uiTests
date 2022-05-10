import pages.SpecData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpecPage;
import pages.MainPage;

public class FindSpecPage_Test extends BaseTest {
  ApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  private MainPage mainPage = context.getBean(MainPage.class);
  private SpecPage specPage = context.getBean(SpecPage.class);

  @Test
  public void navigateToJavaQaSpecPage() {

    mainPage.open();
    mainPage.checkButtonTitleOnQaSpecPage();

    Assert.assertEquals(specPage.getRedirectButton().getText(), "Оставить заявку");

  }
}
