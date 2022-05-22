import components.MainMenuComponent;
import data.SpecData;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SpecPage;

public class FindSpecPage_Test extends BaseTest {
  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  private MainPage mainPage = context.getBean("mainPage", MainPage.class);
  private SpecPage specPage = context.getBean("specPage", SpecPage.class);
  private MainMenuComponent component = context.getBean("", MainMenuComponent.class);

  @Test
  public void navigateToJavaQaSpecPage() {

    mainPage.open();
    component.checkOpenSpecPage(SpecData.QA_AUTOMATION);

    specPage.checkRedirButtonText("Оставить заявку");

  }
}
