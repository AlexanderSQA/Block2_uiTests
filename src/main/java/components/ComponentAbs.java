package components;

import org.openqa.selenium.support.PageFactory;
import support.GuiceScoped;


public abstract class ComponentAbs<T> {
  protected GuiceScoped guiceScoped;


  public ComponentAbs(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
    PageFactory.initElements(guiceScoped.driver, this);
  }
}
