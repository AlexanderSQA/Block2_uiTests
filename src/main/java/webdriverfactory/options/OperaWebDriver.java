package webdriverfactory.options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class OperaWebDriver implements IBrowserOptions{
  @Override
  public WebDriver getDriver() {
    OperaOptions options = new OperaOptions();
    options.addArguments("--window-size=1920,1080");
    return new OperaDriver(options);
  }
}
