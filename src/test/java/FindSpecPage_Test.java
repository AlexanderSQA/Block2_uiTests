import components.MainMenuComponent;
import data.SpecData;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SpecPage;


public class FindSpecPage_Test extends BaseTest {
  @Autowired
  private MainPage mainPage;
  @Autowired
  private SpecPage specPage;
  @Autowired
  private MainMenuComponent component;

  @Test
  public void navigateToJavaQaSpecPage() {

    mainPage.open();
    component.checkOpenSpecPage(SpecData.QA_AUTOMATION);

    specPage.checkRedirButtonText("Оставить заявку");

  }
}
