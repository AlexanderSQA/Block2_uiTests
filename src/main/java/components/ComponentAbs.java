package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;
import support.GuiceScoped;


public abstract class ComponentAbs<T> {
  protected GuiceScoped guiceScoped;


  public ComponentAbs(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
    PageFactory.initElements(guiceScoped.driver, this);
  }
}
