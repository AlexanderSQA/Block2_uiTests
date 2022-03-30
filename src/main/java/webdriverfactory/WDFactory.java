package webdriverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import webdriverfactory.options.ChromeWebDriver;

import exceptions.DriverNotSupported;

public class WDFactory {

  public WebDriver getDriver(String browserName) throws DriverNotSupported {

    switch (Browsers.valueOf(browserName)) {
      case CHROME:
        WebDriverManager.chromedriver().setup();
        return new ChromeWebDriver().getDriver();
      case OPERA:
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
      case FIREFOX:
        WebDriverManager.operadriver().setup();
        return new FirefoxDriver();
      default:
        throw new DriverNotSupported("Unexpected value: " + browserName);
    }
  }
}
