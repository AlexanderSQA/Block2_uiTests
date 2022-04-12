import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaAutoSpecPage;
import pages.MainPage;

public class FindJavaAutoSpecPage_Test extends BaseTest {
  @Test
  public void navigateToJavaQaSpecPage() {
    MainPage mainPage = new MainPage(driver);
    JavaAutoSpecPage javaAutoPage = new JavaAutoSpecPage(driver);

    mainPage.open();

    mainPage
        .moveToElementActions(actions, mainPage.getCourseMenuItem())
        .moveToElementActions(actions, mainPage.getTestingSubMenuItem())
        .moveToElementActions(actions, mainPage.getDropDownMenuTrigger())
        .moveToElementAndClickActions(actions, mainPage.getSpecJavaAutomation());

    Assert.assertEquals(javaAutoPage.getRedirectButton().getText(), "Оставить заявку");

  }
}
