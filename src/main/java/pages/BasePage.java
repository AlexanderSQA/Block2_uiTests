package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import support.GuiceScoped;


public abstract class BasePage<T> {

  protected GuiceScoped guiceScoped;
  private String path;

  private By mainBanner = By.tagName("h1");


  public BasePage(GuiceScoped guiceScoped, String path) {
    this.guiceScoped = guiceScoped;
    this.path = path;
    PageFactory.initElements(guiceScoped.driver, this);
  }

  public T open() {
    guiceScoped.driver.get(System.getProperty("base.url") + path);
    return (T) this;
  }

  public T mainBannerShouldBeHasHeader(String expectedHeader) {
    //    guiceScoped.wait.until(ExpectedConditions.visibilityOfElementLocated(mainBanner));
    Assert.assertEquals(guiceScoped.driver.findElement(mainBanner).getText(), expectedHeader);
    return (T) this;
  }

}
