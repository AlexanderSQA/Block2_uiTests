import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageOpen_Test extends BaseTest {

  @Test
  public void test() {
    MainPage mainPage = new MainPage(driver);
    mainPage.open();
    wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.mainBanner));

    Assert.assertEquals(driver.findElement(mainPage.mainBanner).getText(), "Авторские онлайн‑курсы для профессионалов");
  }
}
