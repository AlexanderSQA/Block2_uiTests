package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class ComponentAbs<T> {
  protected WebDriver driver;
  protected Actions actions;

  public ComponentAbs(WebDriver driver) {
    this.driver = driver;
    this.actions = new Actions(driver);
    PageFactory.initElements(driver, this);
  }
}
