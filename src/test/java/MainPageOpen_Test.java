import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;
import pages.MainPage;
import support.SpringConfig;

public class MainPageOpen_Test extends BaseTest {
  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

  private MainPage mainPage = context.getBean("mainPage", MainPage.class);

  @Test
  public void checkOpeningMainPage() {
    mainPage.open()
        .mainBannerShouldBeHasHeader("Авторские онлайн‑курсы для профессионалов");
  }
}
