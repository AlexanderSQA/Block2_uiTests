package components;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import support.GuiceScoped;


public abstract class ComponentAbs<T> {
  protected GuiceScoped guiceScoped;


  public ComponentAbs(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
    PageFactory.initElements(guiceScoped.driver, this);
  }
}
