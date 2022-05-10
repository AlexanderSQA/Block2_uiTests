import data.PageData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppNonAuthPage;
import pages.MainPage;
import pages.SpecPage;

public class RedirectToAppNonAuthPage_Test extends BaseTest {
  ApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  private SpecPage specPage = context.getBean(SpecPage.class);
  private AppNonAuthPage appNonAuthPage = context.getBean(AppNonAuthPage.class);

  @Test
  public void redirectToAuthFormIfNotLogin() {

    specPage.open();

    specPage
        .clickAppButton()
        .clickRedirectButton();
    specPage.waitPageBeVisible("/assessment/" + PageData.valueOf("ID"));

    Assert.assertEquals(appNonAuthPage.getNoRefTitle().getText(), "СПЕЦИАЛИЗАЦИЯ QA AUTOMATION ENGINEER");

  }
}
