import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppNonAuthPage;
import pages.JavaAutoSpecPage;

public class RedirectToAppNonAuthPage_Test extends BaseTest {
  @Test
  public void test() {

    JavaAutoSpecPage javaAutoSpecPage = new JavaAutoSpecPage(driver);
    AppNonAuthPage appNonAuthPage = new AppNonAuthPage(driver);

    javaAutoSpecPage.open();

    javaAutoSpecPage
        .clickAppButton(actions, javaAutoSpecPage.getAppButton())
        .clickRedirectButton(actions, javaAutoSpecPage.getRedirectButton()); //TODO по какой-то причине падает по тайм-ауту


    Assert.assertEquals(appNonAuthPage.getNoRefTitle().getText(), "СПЕЦИАЛИЗАЦИЯ QA AUTOMATION ENGINEER");

  }
}
