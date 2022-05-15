package pages;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

import data.PageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import support.SpringScoped;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class AppNonAuthPage extends BasePage<AppNonAuthPage> {
  private String id;

  @Autowired
  public AppNonAuthPage(SpringScoped springScoped, PageData page) {
    super(springScoped, "/assessment/" + page.getId());
    id = page.getId();
  }

  public WebElement getNoRefTitle() {
    return springScoped.driver.findElement(By.xpath(String.format("//div[@class = 'assessment-title__main_new']/a[contains(text(), %s)]", id)));
  }

  public AppNonAuthPage checkNonAuthPageTitle() {
    Assert.assertEquals(getNoRefTitle().getText(), "СПЕЦИАЛИЗАЦИЯ QA AUTOMATION ENGINEER");
    return this;
  }

}
