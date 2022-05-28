package support;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Locale;

@ScenarioScoped
public class GuiceScoped {
  public String browserName;
  public WebDriver driver;
  public Actions actions;
  //  public WebDriverWait wait = new WebDriverWait(driver, 4);
}
