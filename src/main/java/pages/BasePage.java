package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BasePage<T> {

  private final String path;
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Actions actions;

  public BasePage(WebDriver driver, String path) {
    this.driver = driver;
    this.path = path;
    this.wait = new WebDriverWait(driver, 4);
    this.actions = new Actions(driver);
    PageFactory.initElements(driver, this);
  }

  public T open() {
    driver.get(System.getProperty("base.url") + path);
    return (T) this;
  }


}
