import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.MainPage;

public class FindQASpec_Test extends BaseTest{
  @Test
  public void test(){
    MainPage mainPage = new MainPage(driver);
    mainPage.open();
    actions = new Actions(driver);
    actions.moveToElement(mainPage.courseMenuItem).perform();
    actions.moveToElement(mainPage.testingSubMenuItem).perform();
    actions.moveToElement(mainPage.dropDownMenuTrigger).perform();
    actions.moveToElement(mainPage.specJavaAutomation).click().build().perform();
    wait.until(ExpectedConditions.urlContains("qa-auto-java-specialization"));

  }
}
