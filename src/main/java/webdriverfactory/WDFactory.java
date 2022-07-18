package webdriverfactory;

import com.google.inject.Inject;
import exceptions.DriverNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.MouseListeners;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import support.GuiceScoped;
import webdriverfactory.options.ChromeWebDriver;
import webdriverfactory.options.FirefoxWebDriver;
import webdriverfactory.options.OperaWebDriver;
import webdriverfactory.options.Remote;
import java.net.URL;
import java.util.Locale;


public class WDFactory {

  public GuiceScoped guiceScoped;

  @Inject
  public WDFactory(GuiceScoped guiceScoped) {
    this.guiceScoped = guiceScoped;
  }

  public EventFiringWebDriver getDriver() {
    EventFiringWebDriver driver;
    switch (guiceScoped.browserName.trim().toUpperCase(Locale.ROOT)) {
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
        driver = new EventFiringWebDriver(new Remote().getDriver());
      //        throw new DriverNotSupportedException("Unexpected browser");
    }
    driver.register(new MouseListeners());
    return driver;
  }
}
