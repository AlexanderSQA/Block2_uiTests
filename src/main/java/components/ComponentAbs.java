package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public abstract class ComponentAbs<T> {
  protected WebDriver driver;
  protected Actions actions;

  public ComponentAbs(WebDriver driver, Actions actions) {
    this.driver = driver;
    this.actions = actions;
    PageFactory.initElements(driver, this);
  }
}
