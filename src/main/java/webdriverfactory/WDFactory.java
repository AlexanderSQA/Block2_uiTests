package webdriverfactory;

import exceptions.DriverNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.MouseListeners;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import webdriverfactory.options.ChromeWebDriver;
import webdriverfactory.options.FirefoxWebDriver;
import webdriverfactory.options.OperaWebDriver;
import java.util.Locale;


public class WDFactory {

  public EventFiringWebDriver getDriver() {
    EventFiringWebDriver driver;

    switch (System.getProperty("browser").trim().toUpperCase(Locale.ROOT)) {
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
