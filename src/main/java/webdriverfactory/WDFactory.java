package webdriverfactory;

import exceptions.DriverNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.MouseListeners;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import support.GuiceScoped;
import webdriverfactory.options.ChromeWebDriver;
import webdriverfactory.options.FirefoxWebDriver;
import webdriverfactory.options.OperaWebDriver;
import java.util.Locale;


public class WDFactory {

  public GuiceScoped guiceScoped;

  public WDFactory(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
  }

  public EventFiringWebDriver getDriver() {
    EventFiringWebDriver driver;
    System.out.println("DEBUG: " + System.getProperty("browser"));
    switch (guiceScoped.browserName) {
      case "CHROME":
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeWebDriver().getDriver());
        break;
      case "OPERA":
        WebDriverManager.operadriver().setup();
        driver = new EventFiringWebDriver(new OperaWebDriver().getDriver());
        break;
      case "FIREFOX":
        WebDriverManager.operadriver().setup();
        driver = new EventFiringWebDriver(new FirefoxWebDriver().getDriver());
        break;
      default:
        throw new DriverNotSupportedException("Unexpected browser");
    }
    driver.register(new MouseListeners());
    return driver;
  }
}
