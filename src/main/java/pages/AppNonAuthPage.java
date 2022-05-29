package pages;

import com.google.inject.Inject;
import data.PageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import support.GuiceScoped;


public class AppNonAuthPage extends BasePage<AppNonAuthPage> {
  private String id;

  @Inject
  public AppNonAuthPage(GuiceScoped guiceScoped, PageData page) {
    super(guiceScoped, "/assessment/" + page.getId());
    id = page.getId();
  }

  public WebElement getNoRefTitle() {
    return guiceScoped.driver.findElement(By.xpath(String.format("//div[@class = 'assessment-title__main_new']/a[contains(text(), %s)]", id)));
  }

  public AppNonAuthPage checkNonAuthPageTitle() {
    Assert.assertEquals(getNoRefTitle().getText(), "СПЕЦИАЛИЗАЦИЯ QA AUTOMATION ENGINEER");
    return this;
  }

}
