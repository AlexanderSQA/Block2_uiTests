package webdriverfactory.options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxWebDriver implements IBrowserOptions {

  @Override
  public WebDriver getDriver() {
    FirefoxOptions options = new FirefoxOptions();
    options.addArguments("--kiosk");
    return new FirefoxDriver(options);
  }
}
