import data.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.SpecPage;

public class RedirectToAppNonAuthPage_Test extends BaseTest {
  @Autowired
  private SpecPage specPage;


  @Test
  public void redirectToAuthFormIfNotLogin() {

    specPage.open()
        .clickAppButton()
        .clickRedirectButton(PageData.QA)
        .checkNonAuthPageTitle();
  }
}
