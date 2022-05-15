package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.SpringScoped;

public abstract class BasePage<T> {

  private final String path;

  protected WebDriverWait wait;
  protected Actions actions;
  protected SpringScoped springScoped;

  @FindBy(tagName = "h1")
  private By mainBanner;

  public BasePage(SpringScoped springScoped, String path) {
    this.springScoped = springScoped;
    this.path = path;
    PageFactory.initElements(driver, this);
  }

  public T open() {
    driver.get(System.getProperty("base.url") + path);
    return (T) this;
  }

  public T mainBannerShouldBeHasHeader(String header){
    wait.until(ExpectedConditions.visibilityOfElementLocated(mainBanner));
    Assert.assertEquals(driver.findElement(mainBanner).getText(), header);
    return (T)this;
  }
}
