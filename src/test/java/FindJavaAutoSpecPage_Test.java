import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.JavaAutoSpecPage;

public class FindJavaAutoSpecPage_Test extends BaseTest{
  @Test
  public void test()  {
    MainPage mainPage = new MainPage(driver);
    JavaAutoSpecPage javaAutoPage = new JavaAutoSpecPage(driver);

    mainPage.open();

    mainPage
        .moveToElementActions(actions, mainPage.courseMenuItem)
        .moveToElementActions(actions, mainPage.testingSubMenuItem)
        .moveToElementActions(actions, mainPage.dropDownMenuTrigger)
        .moveToElementAndClickActions(actions, mainPage.specJavaAutomation);

    Assert.assertEquals(javaAutoPage.redirectButton.getText(), "Оставить заявку");

  }
}
