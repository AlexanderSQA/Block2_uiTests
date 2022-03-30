package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  protected WebDriver driver;

  private String path;

  public BasePage(WebDriver driver, String path) {
    this.driver = driver;
    this.path = path;
    PageFactory.initElements(driver, this);
  }

  public void open() {
    driver.get(System.getProperty("base.url") + path);
  }
}
