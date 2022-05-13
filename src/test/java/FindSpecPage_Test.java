import components.MainMenuComponent;
import data.SpecData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SpecPage;

public class FindSpecPage_Test extends BaseTest {
  ApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  private MainPage mainPage = context.getBean(MainPage.class);
  private SpecPage specPage = context.getBean(SpecPage.class);
  private MainMenuComponent component = context.getBean(MainMenuComponent.class);

  @Test
  public void navigateToJavaQaSpecPage() {

    mainPage.open();
    component.checkOpenSpecPage(SpecData.QA_AUTOMATION.getSubMenuName());

    specPage.checkRedirButtonText("Оставить заявку");

  }
}
