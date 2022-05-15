import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageOpen_Test extends BaseTest {
  @Autowired
  private MainPage mainPage;

  @Test
  public void checkOpeningMainPage() {
    mainPage.open()
        .mainBannerShouldBeHasHeader("Авторские онлайн‑курсы для профессионалов");
  }
}
