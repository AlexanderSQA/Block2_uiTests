import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageOpen_Test extends BaseTest {
  ApplicationContext context = new AnnotationConfigApplicationContext(MainPage.class);
  private MainPage mainPage = context.getBean(MainPage.class);

  @Test
  public void checkOpeningMainPage() {
    mainPage.open()
        .mainBannerShouldBeHasHeader("Авторские онлайн‑курсы для профессионалов");
  }
}
