package webdriverfactory;

import exceptions.DriverNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.MouseListeners;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import webdriverfactory.options.ChromeWebDriver;
import webdriverfactory.options.FirefoxWebDriver;
import webdriverfactory.options.OperaWebDriver;

public class WDFactory {

  public EventFiringWebDriver getDriver(String browserName) throws DriverNotSupported {

    switch (Browsers.valueOf(browserName)) {
      case CHROME:
        WebDriverManager.chromedriver().setup();
        EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeWebDriver().getDriver());
        driver.register(new MouseListeners());
        return driver;
      case OPERA:
        WebDriverManager.operadriver().setup();
        driver = new EventFiringWebDriver(new OperaWebDriver().getDriver());
        driver.register(new MouseListeners());
        return driver;
      case FIREFOX:
        WebDriverManager.operadriver().setup();
        driver = new EventFiringWebDriver(new FirefoxWebDriver().getDriver());
        driver.register(new MouseListeners());
        return driver;
      default:
        throw new DriverNotSupported("Unexpected value: " + browserName);
    }
  }
}
