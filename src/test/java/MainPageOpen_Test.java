import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageOpen_Test extends BaseTest {
  ApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  private MainPage mainPage = context.getBean(MainPage.class);

  @Test
  public void checkOpeningMainPage() {
    mainPage.open();
    wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage.mainBanner));

    Assert.assertEquals(driver.findElement(mainPage.mainBanner).getText(), "Авторские онлайн‑курсы для профессионалов");
  }
}
