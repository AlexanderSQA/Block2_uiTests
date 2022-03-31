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

    javaAutoSpecPage.clickAppButton(actions, javaAutoSpecPage.appButton);
    javaAutoSpecPage.clickRedirectButton(actions, javaAutoSpecPage.redirectButton);

    wait.until(ExpectedConditions.urlContains("/assessment/275/"));

    Assert.assertEquals(appNonAuthPage.noRefTitle.getText(), "Специализация QA Automation Engineer");

  }
}
