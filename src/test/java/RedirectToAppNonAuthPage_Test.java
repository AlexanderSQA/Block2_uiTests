import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppNonAuthPage;
import pages.JavaAutoSpecPage;
import pages.MainPage;

public class RedirectToAppNonAuthPage_Test extends BaseTest{
  @Test
  public void test(){

    JavaAutoSpecPage javaAutoSpecPage = new JavaAutoSpecPage(driver);
    AppNonAuthPage appNonAuthPage = new AppNonAuthPage(driver);

    javaAutoSpecPage.open();

    javaAutoSpecPage
            .clickAppButton(actions, javaAutoSpecPage.appButton)
            .clickRedirectButton(actions, javaAutoSpecPage.redirectButton); //TODO по какой-то причине падает по тайм-ауту

    wait.until(ExpectedConditions.urlContains("/assessment/275/"));

    Assert.assertEquals(appNonAuthPage.noRefTitle.getText(), "СПЕЦИАЛИЗАЦИЯ QA AUTOMATION ENGINEER");

  }
}
