package support;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@ScenarioScoped
public class GuiceScoped {
  public String browserName;
  public WebDriver driver;
  public Actions actions;

}
