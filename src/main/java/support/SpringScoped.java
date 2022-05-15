package support;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriverfactory.WDFactory;
import java.util.Locale;

@ScenarioScope
public class SpringScoped {
  public WebDriver driver = new WDFactory().getDriver(System.getProperty("browser").toUpperCase(Locale.ROOT));
  public WebDriverWait wait = new WebDriverWait(driver, 4);
  public Actions actions = new Actions(driver);

}
