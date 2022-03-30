package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

  protected WebDriver driver;

  private String path;

  public BasePage(WebDriver driver, String path) {
    this.driver = driver;
    this.path = path;
  }

  public void open() {
    driver.get(System.getProperty("base.url") + path);
  }
}
