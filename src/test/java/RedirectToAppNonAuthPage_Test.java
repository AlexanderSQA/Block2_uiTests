import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppNonAuthPage;
import pages.JavaAutoSpecPage;

public class RedirectToAppNonAuthPage_Test extends BaseTest {
  @Test
  public void redirectToAuthFormIfNotLogin() {

    JavaAutoSpecPage javaAutoSpecPage = new JavaAutoSpecPage(driver);
    AppNonAuthPage appNonAuthPage = new AppNonAuthPage(driver);

    javaAutoSpecPage.open();

    javaAutoSpecPage
        .clickAppButton(actions, javaAutoSpecPage.getAppButton())
        .clickRedirectButton(actions, javaAutoSpecPage.getRedirectButton());
    javaAutoSpecPage.waitPageBeVisible("/assessment/275/");

    Assert.assertEquals(appNonAuthPage.getNoRefTitle().getText(), "СПЕЦИАЛИЗАЦИЯ QA AUTOMATION ENGINEER");

  }
}
