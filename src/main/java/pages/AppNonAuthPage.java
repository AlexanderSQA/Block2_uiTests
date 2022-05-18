package pages;

import data.PageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
public class AppNonAuthPage extends BasePage<AppNonAuthPage> {
  private String id;

  @Autowired
  public AppNonAuthPage(WebDriver driver, PageData page) {
    super(driver, "/assessment/" + page.getId());
    id = page.getId();
  }

  public WebElement getNoRefTitle() {
    return driver.findElement(By.xpath(String.format("//div[@class = 'assessment-title__main_new']/a[contains(text(), %s)]", id)));
  }

  public AppNonAuthPage checkNonAuthPageTitle() {
    Assert.assertEquals(getNoRefTitle().getText(), "СПЕЦИАЛИЗАЦИЯ QA AUTOMATION ENGINEER");
    return this;
  }

}
